package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Account;
import com.example.demo.entities.Client;

public interface AccountRepository extends JpaRepository<Account,String>
{

}
