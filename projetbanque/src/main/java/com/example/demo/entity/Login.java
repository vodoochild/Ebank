package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;





@Entity
public class Login implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
    public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String email;
    public String getPassword() {
		/*
		 * String pass = null; BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
		 * pass =(bcr.encode((CharSequence)pass)); return this.password=pass;
		 */
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;

    public Login(Long id,String email,String pass){
        this.id = id ;
        this.email=email;
      /* BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
       pass =(bcr.encode((CharSequence)pass));*/
        this.password=pass;
    }

}
