package com.example.demo.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("sa")
public class SavingAccount extends Account
{
	private double tax;

	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public SavingAccount(String codeAccount, Date dateCreation, double balance, Client client, double tax) {
		super(codeAccount, dateCreation, balance, client);
		this.tax = tax;
	}




	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	

}
