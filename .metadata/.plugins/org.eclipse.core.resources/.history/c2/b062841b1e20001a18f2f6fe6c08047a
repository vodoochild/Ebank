package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Agent implements Serializable {
	 @Id
	    @GeneratedValue
	    private Integer Id;
	    private String nom;
	    private String prenom;
	    @OneToMany(mappedBy = "compte")
	    private Collection<Client>clients;
	    
		public Agent(Integer id, String nom, String prenom, Collection<Client> clients) {
			super();
			Id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.clients = clients;
		}
		
		public Agent() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public Collection<Client> getClients() {
			return clients;
		}
		public void setClients(Collection<Client> clients) {
			this.clients = clients;
		}
	    

}
