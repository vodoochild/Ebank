package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.*;
public interface CompteRepository extends JpaRepository<Compte,String> {

}
