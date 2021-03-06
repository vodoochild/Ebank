package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.lang.RuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dao.*;
import com.example.demo.entity.*;


@Service
@Transactional
public class bankServiceImpl implements IbankService {
@Autowired
private CompteRepository compteRepository;
@Autowired
private OperationRepository operationRepositry;
@Autowired
private IbankService bankService;
	@Override
	public Compte ConsulterCompte(String codeCompte) {
		Compte cp2 = new Compte();
			Optional<Compte>  cp= compteRepository.findById(codeCompte);
			if(cp.isPresent()) {
			cp2=cp.get();
			}
			else if(!cp.isPresent())throw new RuntimeException("Compte introuvable !");
		return cp2;
	}

	@Override
	public ResponseEntity <?> verser(String codeCompte, double montant) {
		Compte cp = ConsulterCompte(codeCompte);
		Versement versement = new Versement(new Date(), montant, cp);
		operationRepositry.save(versement);
		cp.setSolde(cp.getSolde()+montant);
		compteRepository.save(cp);
		return ResponseEntity.ok(null);
		
	}

	@Override
	public ResponseEntity <?> retirer(String codeCompte, double montant) {
		Compte cp = ConsulterCompte(codeCompte);
		if(cp.getSolde()<montant) {
			throw new RuntimeException("solde insuffisant!");
		}
		Retrait r  = new Retrait(new Date(), montant, cp);
		operationRepositry.save(r);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
		return ResponseEntity.ok(null);
		
	}

	@Override
	public ResponseEntity <?>  virement(String codeCompte1, String codeCompte2, double montant) {
		retirer(codeCompte1,montant);
		verser(codeCompte2,montant);
		return ResponseEntity.ok(null);
		
	}

	
	@Override
	public List<Operation> listeOperation(String codeCompte) {
		
		return operationRepositry.listeOperation(codeCompte);
	}

	

}
