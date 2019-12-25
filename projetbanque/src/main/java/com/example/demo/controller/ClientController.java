package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Client;
import com.example.demo.entity.Compte;
import com.example.demo.entity.Login;
import com.example.demo.service.ClientService;
import com.example.demo.service.CompteService;
import com.example.demo.service.LoginService;

@CrossOrigin("*")
@RestController
@RequestMapping("clients")
public class ClientController {
	@Autowired 
	ClientService clientservice;
	@Autowired
	CompteService compteservice;
	@Autowired
	LoginService loginservice;
	 @RequestMapping("/allClients")
	    public List<Client> getAllCLients(){
	        return clientservice.getAllClients();
	    }
	@RequestMapping("/SaveClient")
public void save_client(@RequestBody Client client) {
			Login login=client.getLogin();
	       BCryptPasswordEncoder b=new BCryptPasswordEncoder();
	       login.setPassword(b.encode(login.getPassword()));
	        loginservice.saveLogin(login);
	        Compte compte=new Compte();
	        compte.setClient(client);
	        client.setComptes(null);
	        clientservice.addClient(client);
	        compteservice.saveCompte(compte);
}
	  @DeleteMapping("/deleteClientById")
	    public void deleteClientById(@RequestParam(name="id")Integer id){
	        Client c=clientservice.getById(id);
	        Collection<Compte> comptes =c.getComptes();
	        Login login=c.getLogin();
	        loginservice.deleteLoginById(login.getId());
	        clientservice.deleteClient(c.getId());
	       // compteservice.deleteCompteById(compte.getId());
	    }


}
