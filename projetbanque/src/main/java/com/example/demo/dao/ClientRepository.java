package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.*;
//prend 2 types generique :1-l'entite qu'on va gerer(client),et L'id du client
public interface ClientRepository extends JpaRepository<Client,Long>{
//
}
