package com.example.demo.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("ca")
public class CurrentAccount extends Account
{

	private double decouvert;

	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public CurrentAccount(String codeAccount, Date dateCreation, double balance, Client client, double decouvert) {
		super(codeAccount, dateCreation, balance, client);
		this.decouvert = decouvert;
	}




	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	

}
