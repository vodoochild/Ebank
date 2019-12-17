package com.example.demo;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.CompteRepository;
import com.example.demo.entity.*;
import com.example.demo.service.IbankService;

@SpringBootApplication
public class ProjetbanqueApplication implements CommandLineRunner{
@Autowired
private ClientRepository clientRepository;
@Autowired
private CompteRepository compeRepository;
@Autowired
private IbankService bankservice;
	public static void main(String[] args) {
		System.setProperty("server.port","8083");
	 SpringApplication.run(ProjetbanqueApplication.class, args);
	///ClientRepository clientRepository= ctx.getBean(ClientRepository.class);
	
	}

	@Override
	public void run(String... args) throws Exception {
	Client c2=	clientRepository.save(new Client("khawla","ELHADRI","khawla.elhadri@gmail.com"));
	Compte cp1=compeRepository.save(new Compte("c2",new Date(),9000,c2));
	//bankservice.verser("c1", 9000);
	bankservice.verser("c2", 50000);
	}

}
