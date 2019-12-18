package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Client implements Serializable {
	 @Id
	    @GeneratedValue
	    private Integer Id;
	    private String nom;
	    private String prenom;
	    private  String dateNaissance ;
	    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	    private Collection<Compte> comptes;

	    public Client() {
	        super();
	    }


	    public Integer getId() {
	        return Id;
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
	        Id = id;
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
