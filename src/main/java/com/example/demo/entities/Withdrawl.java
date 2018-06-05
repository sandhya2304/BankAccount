package com.example.demo.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("with")
public class Withdrawl extends AccountDetails
{

	public Withdrawl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Withdrawl(Date dateOperation, double amount, Account accounts) {
		super(dateOperation, amount, accounts);
		// TODO Auto-generated constructor stub
	}

	
	
	

}
