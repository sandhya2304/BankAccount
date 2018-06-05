package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable
{
	@Id @GeneratedValue
	private Long codeClient;
	private String name;
	private String email;
	
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Account> accounts;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	
	public Long getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
	
	
	

}
