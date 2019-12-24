package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginRepository;
import com.example.demo.entity.Login;

@Service
public class LoginService {
	@Autowired
    LoginRepository loginRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
	
	 public Login findbyemail(String email) { return
	 loginRepository.getByEmail(email); }
	 

    public List<Login> findAll(){
        return loginRepository.findAll();
    }
  public boolean passCheck(String email,String password) {

        Login l = loginRepository.getByEmail(email);
        String pass = l.getPassword();
        return bCryptPasswordEncoder.matches(password, pass);

    }
    public Login findbyEmail(String email){
        return loginRepository.getByEmail(email);
    }
    
    public void saveLogin(Login login){
        loginRepository.save(login);
    }
}
