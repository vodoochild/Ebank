package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Compte;
import com.example.demo.entity.Operation;
import com.example.demo.service.IbankService;


@CrossOrigin("*")
@RestController
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
public Compte consulter(String codeCompte) {
	Compte cp= ibankservice.ConsulterCompte(codeCompte);		
	return cp;
}

@RequestMapping("/Versement")
public void payment (@RequestParam("codecompte")String ccompte,@RequestParam("montant")double montant) {
	  ibankservice.verser(ccompte, montant);
	
	
}
@RequestMapping("/Virement")

public void wireTransfer (@RequestParam("codecompte")String ccompte1,@RequestParam("codecompte")String ccompte2,@RequestParam("montant")double montant) {
	  ibankservice.virement(ccompte1, ccompte2, montant);
	
	
}
@RequestMapping("/Retirer")

public void retrieve(@RequestParam("codecompte")String code,@RequestParam("montant")double montant ) {
	ibankservice.retirer(code, montant);
}

@RequestMapping("/AccountTransactions")
public List<Operation> getAllAccountTransactions(@RequestParam("codecompte")String ccompte){
    return ibankservice.listeOperation(ccompte);

}








}
