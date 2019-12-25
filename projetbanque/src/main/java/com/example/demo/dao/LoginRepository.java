package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Login;
@RepositoryRestResource
@CrossOrigin("*")
public interface LoginRepository extends JpaRepository<Login,Long> {
		//public Login findByEmailAndAndPassword(String email,String password);
	    public Login getByEmail(String email);
	   // boolean existsByEmail(String email);
}
