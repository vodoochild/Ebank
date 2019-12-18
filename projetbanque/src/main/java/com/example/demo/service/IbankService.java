package com.example.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.*;

public interface IbankService {
	public Compte ConsulterCompte(String codeCompte);
	public void verser(String codeCompte,double montant);
	public void retirer(String codeCompte,double montant);
	public ResponseEntity <?>  virement(String codeCompte1, String codeCompte2, double montant);
	public Page<Operation> listeOperation(String codeCompte,int page, int size);
	public ResponseEntity <?> ajouterClient(Client cl);
	public ResponseEntity<?> ajouterComptebank(Client cl);
	
}
