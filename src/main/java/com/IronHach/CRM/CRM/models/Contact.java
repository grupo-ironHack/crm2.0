package com.IronHach.CRM.CRM.models;

import javax.persistence.*;

@Entity
// Faltaria @Inheritance porque extiende de Leads?
public class Contact extends Leads{

   /* private static final String ID_STR = "CT-0";
    private static int idCounter = 1;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //---------------------------------------------

    @OneToOne
    private Accounts accountsContacts;

    @OneToOne
    private Opportunity oppContact;

    //---------------------------------------------
    public Contact() {
    }
<<<<<<< HEAD
    public Contact(String name, String phone, String email, String companyName) {
        super(name, phone, email, companyName);
=======
    public Contact(String name, String phone, String email, String companyName, SalesRep salesRep) {
        super(name, phone, email, companyName, salesRep);
        setId(ID_STR + idCounter++);
>>>>>>> origin
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id= " + id +
                ", name=' " + this.getName() + '\"' +
                ", phone' " + this.getPhone() + '\"' +
                ", email' " + this.getEmail() + '\"' +
                ", companyName' " + this.getCompanyName() + '\"' +
                '}';
    }
}