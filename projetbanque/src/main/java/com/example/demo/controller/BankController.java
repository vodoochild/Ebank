package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Compte;
import com.example.demo.service.IbankService;

@Controller
public class BankController {
	//controller needs the services (couche metier)
	@Autowired
	private IbankService ibankservice;
	// method that returns a the view by default
	@RequestMapping("/operations")
	// cela dit que quand je tape http://localhost/operations j'aurai la vue comptes.html
	public String index() {
		return "comptes";
	}
@RequestMapping("/consulterCompte")
public String consulter(Model model ,String codeCompte) {
	
	try {
		Compte cp= ibankservice.ConsulterCompte(codeCompte);
		model.addAttribute("compte", cp);
	} catch(Exception e) {
		model.addAttribute("exception",e);
	}
	
	return "comptes";
}

@RequestMapping("/Versement")
public void payment (@RequestParam("codecompte")String ccompte,@RequestParam("montant")double montant) {
	  ibankservice.verser(ccompte, montant);
	
	
}
@RequestMapping("/Virement")

public void wireTransfer (@RequestParam("codecompte")String ccompte1,@RequestParam("codecompte")String ccompte2,@RequestParam("montant")double montant) {
	  ibankservice.virement(ccompte1, ccompte2, montant);
	
	
}













}
