package com.example.demo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
@Entity
@DiscriminatorValue("V")
public class Virement extends Operation {

    public Virement(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }

    public Virement() {
        super();
    }
}
