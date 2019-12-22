package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Client;
import com.example.demo.entity.Compte;
import com.example.demo.entity.Login;
import com.example.demo.service.ClientService;
import com.example.demo.service.CompteService;
import com.example.demo.service.LoginService;

@RequestMapping("clients")
public class ClientController {
	@Autowired 
	ClientService clientservice;
	@Autowired
	CompteService compteservice;
	@Autowired
	LoginService loginservice;
	
	@RequestMapping("/SaveClient")
public void save_client(@RequestBody Client client) {
			Login login=client.getLogin();
	      //  BCryptPasswordEncoder b=new BCryptPasswordEncoder();
	      //  login.setPassword(b.encode(login.getPassword()));
	        loginservice.saveLogin(login);
	        Compte compte=new Compte();
	        compte.setClient(client);
	        client.setComptes(null);
	        clientservice.addClient(client);
	        compteservice.saveCompte(compte);
}


}
