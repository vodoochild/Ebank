package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.example.demo.entity.*;
//prend 2 types generique :1-l'entite qu'on va gerer(client),et L'id du client

@CrossOrigin("*")
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Integer>{
	Client getById(Integer Id);	
	Client save(Client client);
	void deleteById(Integer Id);
	
}
