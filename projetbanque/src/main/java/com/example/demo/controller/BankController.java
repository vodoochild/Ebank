package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.IbankService;

@Controller
public class BankController {
	//controller needs the services (couche metier)
	@Autowired
	private IbankService ibankservice;
	// method that returns a the view by default
	@RequestMapping("/mypage")
	// cela dit que quand je tape http://localhost/mypage j'aurai la vue page.html
	public String index() {
		return "page";
	}

}
