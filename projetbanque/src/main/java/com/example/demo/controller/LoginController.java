package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Login;
import com.example.demo.service.ClientService;
import com.example.demo.service.LoginService;
@CrossOrigin("*")
@RestController
@RequestMapping("logins")
public class LoginController {
	@Autowired
    LoginService loginService;

    @Autowired
    ClientService clientService;

    
    @GetMapping("/all")
    public List<Login> getAll( ){

        return loginService.findAll();
    }
    
   @RequestMapping("/checkPassword")
    public boolean checkpassword(@RequestParam("email") String email,@RequestParam("password") String password){

        return loginService.passCheck(email,password);

    }
    @RequestMapping("/byEmail")
    public Login getByEmail(@RequestParam("email") String email){

        return loginService.findbyEmail(email);

    }


}
