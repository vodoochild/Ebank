package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Compte;
import com.example.demo.service.CompteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/compte")
public class CompteController {
	@Autowired 
	private CompteService compteservice;
	 @GetMapping(value ="getAllAccounts")
	 
	public List<Compte> getAllUserAccounts(@RequestParam("id")Integer id){
		 return compteservice.getAllClientAcounts(id);
	 }

}
