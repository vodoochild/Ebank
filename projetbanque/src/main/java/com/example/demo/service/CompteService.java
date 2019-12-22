package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.CompteRepository;
import com.example.demo.dao.OperationRepository;
import com.example.demo.entity.Client;
import com.example.demo.entity.Compte;

@Service
public class CompteService {
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Compte> getAllClientAcounts(Integer id){
		return compteRepository.getAllByClient(clientRepository.getById(id));
	}
	
	/*
	 * public Compte getClientsCompte(String codeCompte) { return
	 * compteRepository.getCompte(codeCompte); }
	 */
	public void saveCompte(Compte compte) {
		compteRepository.save(compte);
	}
	  public Compte getCilentCompte(Integer clientId) {
	        Compte compte = compteRepository.findComptebyClient(clientId);
	        return compte;
	    }

}
