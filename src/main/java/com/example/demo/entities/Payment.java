package com.example.demo.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("pay")
public class Payment extends AccountDetails
{

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Date dateOperation, double amount, Account accounts) {
		super(dateOperation, amount, accounts);
		// TODO Auto-generated constructor stub
	}

	
	

}
