package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Login;

public interface LoginRepository extends JpaRepository<Login,Long> {
		//public Login findByEmailAndAndPassword(String email,String password);
	    public Login getByEmail(String email);
	   // boolean existsByEmail(String email);
}
