package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.AccountDetails;
import com.example.demo.entities.Client;

public interface AccountDetailRepository extends JpaRepository<AccountDetails,Long>
{
	
	@Query("select o from AccountDetails o where o.accounts.codeAccount =:x order by o.dateOperation desc")
	public Page<AccountDetails> listOperation(@Param("x")String codeAcct,Pageable pageable);

}
