package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.AccountDetailRepository;
import com.example.demo.dao.AccountRepository;
import com.example.demo.dao.ClientRepository;
import com.example.demo.entities.Account;
import com.example.demo.entities.Client;
import com.example.demo.entities.CurrentAccount;
import com.example.demo.entities.Payment;
import com.example.demo.entities.SavingAccount;
import com.example.demo.entities.Withdrawl;
import com.example.demo.service.IBankService;

@SpringBootApplication
public class AAccountBankApplication implements CommandLineRunner
{
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountDetailRepository accountDetailRepository;
	
	@Autowired
	private IBankService bankService;

	public static void main(String[] args)
	{
        SpringApplication.run(AAccountBankApplication.class, args);
   	
	}

	@Override
	public void run(String... arg0) throws Exception 
	{
		/* Client c1 = clientRepository.save(new Client("ram","ram@gmail.com"));    	
		 Client c2 = clientRepository.save(new Client("shyam","shyam@gmail.com"));    
		 
	
		 Account acc1=accountRepository.save(new CurrentAccount("c1",new Date(),6000,c2,5.5));
		 
		 Account acc2=accountRepository.save(new SavingAccount("c2",new Date(),6000,c2,5.5));
		 
		 accountDetailRepository.save(new Payment(new Date(),9000,acc1));
		 accountDetailRepository.save(new Payment(new Date(),1000,acc1));
		 accountDetailRepository.save(new Payment(new Date(),7000,acc1));
		 accountDetailRepository.save(new Payment(new Date(),3000,acc1));
		 
		 accountDetailRepository.save(new Withdrawl(new Date(),600,acc1));
		 
		 
		 accountDetailRepository.save(new Payment(new Date(),1000,acc2));
		 accountDetailRepository.save(new Payment(new Date(),9000,acc2));
		 accountDetailRepository.save(new Payment(new Date(),3000,acc2));
		 accountDetailRepository.save(new Payment(new Date(),1200,acc2));
		 
		 accountDetailRepository.save(new Withdrawl(new Date(),900,acc2));
		 
		 bankService.pay("c1", 111);
		 */
		 
	}
}
