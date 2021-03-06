package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Client implements Serializable {
	 @Id
	    @GeneratedValue
	    private Integer id;
	    private String nom;
	    private String prenom;
	    private  String dateNaissance ;
	    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	    private Collection<Compte> comptes;
	    @ManyToOne
	    @JoinColumn(name="ID_AGENT")
	    private Agent agent;
	    @OneToOne
	    private Login login;
	    public Agent getAgent() {
			return agent;
		}


		public void setAgent(Agent agent) {
			this.agent = agent;
		}


		public Login getLogin() {
			return login;
		}


		public void setLogin(Login login) {
			this.login = login;
		}


		public Client(String nom, String prenom, String dateNaissance) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.dateNaissance = dateNaissance;
		}


		public Client(String nom, String prenom, String dateNaissance, Agent agent) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.dateNaissance = dateNaissance;
			this.agent = agent;
		}


		public Client() {
	        super();
	    }


	    public Integer getId() {
	        return id;
	    }

	    public String getDateNaissance() {
	        return dateNaissance;
	    }

	    public void setDateNaissance(String dateNaissance) {
	        this.dateNaissance = dateNaissance;
	    }

	    public String getPrenom() {
	        return prenom;
	    }

	    public void setPrenom(String prenom) {
	        this.prenom = prenom;
	    }

	    public void setId(Integer id) {
	        id = id;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }
	    public String getNom() {
	        return nom;
	    }

	    public Collection<Compte> getComptes() {
	        return comptes;
	    }

	    public void setComptes(Collection<Compte> comptes) {
	        this.comptes = comptes;
	    }
}
