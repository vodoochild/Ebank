package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.CompteRepository;
import com.example.demo.dao.OperationRepository;
import com.example.demo.entity.Client;


@Service
public class ClientService {
	@Autowired
	private CompteRepository compteRepository;	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client getById(Integer Id) {
		return clientRepository.getById(Id);
	}
	
	public Client addClient(Client cl) {
		return	clientRepository.save(cl);
	}
	
	public void deleteClient(Integer Id) {
		 clientRepository.deleteById(Id);
	}
	  public List<Client> getAllClients(){
	        return clientRepository.findAll();
	    }
	  

}
