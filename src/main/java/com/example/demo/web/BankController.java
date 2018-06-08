package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Account;
import com.example.demo.entities.AccountDetails;
import com.example.demo.service.IBankService;

@Controller
public class BankController
{
	
	@Autowired
	private IBankService bankService;
	
	
	@RequestMapping("/operation")
	public String index()
	{
		return "accounts";
	}
	
	
	@RequestMapping("/consultAccount")
	public String consultAccount(Model model,String codeAcct)
	{
		model.addAttribute("codeAccount",codeAcct);
		
		try
		{
			Account account=bankService.toConsultAccount(codeAcct);
			Page<AccountDetails> operation=bankService.listOperation(codeAcct,0, 5);
			
			model.addAttribute("listOperation",operation.getContent());
			model.addAttribute("account", account);
			
			
		}catch(Exception e)
		{
			model.addAttribute("exception",e);
			
		}

		return "accounts";
	}
	
	@RequestMapping(value="/saveOperation",method=RequestMethod.POST)
	public String saveOperation(Model model,String typeOperation,String codeAcct,
			                double amount,String codeAccount2)
	{
		try
		{
			if(typeOperation.equals("pay"))
			{
				bankService.pay(codeAcct, amount);
			}
			else if(typeOperation.equals("with"))
			{
				bankService.withdraw(codeAcct, amount);
			}
			if(typeOperation.equals("tra"))
			{
				bankService.transfer(codeAcct, codeAccount2, amount);
			}
			
		}catch(Exception e)
		{
			model.addAttribute("error",e);
			return "redirect:/consultAccount?accounts="+codeAcct+"&error="+e.getMessage();
		}
		
		
		
		return "redirect:/consultAccount?accounts="+codeAcct;
	}
	

}
