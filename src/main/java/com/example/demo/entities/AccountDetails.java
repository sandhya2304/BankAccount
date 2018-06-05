package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="account_detail",discriminatorType=DiscriminatorType.STRING,length=1)
public abstract class AccountDetails implements Serializable
{
	@Id @GeneratedValue
	private long codeOperation;
	private Date dateOperation;
	private double amount;
	
	
	@ManyToOne
	@JoinColumn(name="code_acct")
	private Account accounts;
	
	
	public AccountDetails() {
		// TODO Auto-generated constructor stub
	}


	

	public AccountDetails(Date dateOperation, double amount, Account accounts) {
		super();
		this.dateOperation = dateOperation;
		this.amount = amount;
		this.accounts = accounts;
	}




	public long getCodeOperation() {
		return codeOperation;
	}


	public void setCodeOperation(long codeOperation) {
		this.codeOperation = codeOperation;
	}


	public Date getDateOperation() {
		return dateOperation;
	}


	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Account getAccounts() {
		return accounts;
	}


	public void setAccounts(Account accounts) {
		this.accounts = accounts;
	}
	
	

}
