package com.example.demo.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDetailRepository;
import com.example.demo.dao.AccountRepository;
import com.example.demo.entities.Account;
import com.example.demo.entities.AccountDetails;
import com.example.demo.entities.CurrentAccount;
import com.example.demo.entities.Payment;
import com.example.demo.entities.Withdrawl;


@Service
@Transactional
public class BankServiceImpl implements IBankService
{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountDetailRepository accountDetailRepository;
	
	@Override
	public Account toConsultAccount(String codeAcct) {
		Account acc=accountRepository.findOne(codeAcct);
		if(acc==null) throw new RuntimeException("account not found"+codeAcct);
		return acc;
	}

	@Override
	public void pay(String codeAcct, double amt) {
	 
		Account acc=toConsultAccount(codeAcct);
		Payment payment=new Payment(new Date(), amt, acc);
		
		accountDetailRepository.save(payment);
		acc.setBalance(acc.getBalance()+amt);
		
		accountRepository.save(acc);
	}

	@Override
	public void withdraw(String codeAcct, double amt)
	{
		Account acc=toConsultAccount(codeAcct);
		
		double facilitiesCheckout = 0;
	
		if(acc instanceof CurrentAccount)
	
		   facilitiesCheckout=((CurrentAccount)acc).getDecouvert();
		
		if(acc.getBalance()+facilitiesCheckout<amt)
			throw new RuntimeException("amount insuffcicint");
		
		Withdrawl withdrawl=new Withdrawl(new Date(), amt, acc);
		accountDetailRepository.save(withdrawl);
		acc.setBalance(acc.getBalance()-amt);
		
		accountRepository.save(acc);
		
	}

	@Override
	public void transfer(String codeAcct1, String codeAcct2, double amt) 
	{
		
		if(codeAcct1.equals(codeAcct2))
			throw new RuntimeException("inpossible amount transfer to the same account!!!");
		
	    withdraw(codeAcct1, amt);
	    pay(codeAcct2, amt);
		
	}

	@Override
	public Page<AccountDetails> listOperation(String codeAcct, int page, int size)
	{
		 	
		return accountDetailRepository.listOperation(codeAcct, new PageRequest(page, size));
	}
	
	
	

}
