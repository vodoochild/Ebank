package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.*;
import java.util.List;
public interface CompteRepository extends JpaRepository<Compte,String> {
	
	public List<Compte> getAllByClient(Client client);
	//public Compte getCompte(String codeCompte);
	@Query("select c from Compte c where c.client.id =:x ")
	public Compte findComptebyClient(@Param("x")Integer clId );

}
