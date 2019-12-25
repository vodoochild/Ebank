package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.*;

public interface IbankService {
	public Compte ConsulterCompte(String codeCompte);
	public ResponseEntity <?>  verser(String codeCompte,double montant);
	public ResponseEntity <?> retirer(String codeCompte,double montant);
	public ResponseEntity <?> virement(String codeCompte1, String codeCompte2, double montant);
	public List<Operation>listeOperation(String codeCompte);

	
}
