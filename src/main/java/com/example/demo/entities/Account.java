package com.example.demo.entities;

/*
 * @date ---> 19 may
 * 
 */

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_account",discriminatorType=DiscriminatorType.STRING,length=2)
public abstract class Account implements Serializable
{
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String codeAccount;
	private Date dateCreation;
	private double balance;
	@ManyToOne
	@JoinColumn(name="code_cli")
	private Client client;
	@OneToMany(mappedBy="accounts")
	private Collection<AccountDetails> accountDetails;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Account(String codeAccount, Date dateCreation, double balance, Client client) {
		super();
		this.codeAccount = codeAccount;
		this.dateCreation = dateCreation;
		this.balance = balance;
		this.client = client;
	}



	public String getCodeAccount() {
		return codeAccount;
	}
	public void setCodeAccount(String codeAccount) {
		this.codeAccount = codeAccount;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Collection<AccountDetails> getAccountDetails() {
		return accountDetails;
	}
	public void setAccountDetails(Collection<AccountDetails> accountDetails) {
		this.accountDetails = accountDetails;
	}
	
	
	
	

}
