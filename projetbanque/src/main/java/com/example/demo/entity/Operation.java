package com.example.demo.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="TYPE_OP",discriminatorType = DiscriminatorType.STRING, length = 1)
public class Operation  implements Serializable {
	 @Id
	    @GeneratedValue
	    private long numero;
	    private Date dateOperation;
	    private double montant;
	    @ManyToOne
//	    @JoinColumn(name="CODE_CPTE")
	    private Compte compte;
	    public Operation(){
	        super();
	    }
	    public Operation(Date dateOperation ,double montant, Compte compte) {
	        super();
	        this.dateOperation = dateOperation;
	        this.montant=montant;
	        this.compte=compte;
	    }

	    public long getNumero() {
	        return numero;
	    }

	    public void setNumero(long numero) {
	        this.numero = numero;
	    }

	    public Date getDateOperation() {
	        return dateOperation;
	    }

	    public void setDateOperation(Date dateOperation) {
	        this.dateOperation = dateOperation;
	    }

	    public double getMontant() {
	        return montant;
	    }

	    public void setMontant(double montant) {
	        this.montant = montant;
	    }

	    public Compte getCompte() {
	        return compte;
	    }

	    public void setCompte(Compte compte) {
	        this.compte = compte;
	    }
}