package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Account;
import com.example.demo.entities.AccountDetails;

public interface IBankService
{
	
	public Account toConsultAccount(String codeAcct);
	public void pay(String codeAcct,double amt);
	public void withdraw(String codeAcct,double amt);
	public void transfer(String codeAcct1,String codeAcct2,double amt);
	public Page<AccountDetails> listOperation(String codeAcct,int page,int size);
	

}
