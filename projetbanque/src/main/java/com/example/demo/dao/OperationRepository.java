package com.example.demo.dao;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Operation;
@RepositoryRestResource
@CrossOrigin("*")
public interface OperationRepository extends JpaRepository<Operation,Long> {
	//Pageable used to return pages
	//use query notation to specify the query we want to use HQL query
	
	@Query("select o from Operation o where o.compte.codeCompte =:x")
		public List<Operation>listeOperation(@Param("x")String codeCompte);
}
