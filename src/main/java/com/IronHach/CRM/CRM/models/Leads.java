package com.IronHach.CRM.CRM.models;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@Entity
public class Leads {
    /*
    private static final String ID_STR = "LD-0";
    private static int idCounter = 1;
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String companyName;
    //---------------------------------------------
    static Scanner scanner = new Scanner(System.in);
    public static List<Leads> arrayOfLeads = new ArrayList<>();
    //---------------------------------------------
    @ManyToOne
    private SalesRep leadsListSR;

<<<<<<< HEAD
=======
    private Contact contact;

    private SalesRep salesRep;
>>>>>>> origin
    //---------------------------------------------

    //Constructors--------------------------------
    public Leads() {
    }
    public Leads(String name, String phone, String email, String companyName) {
        setName(name);
        setPhone(phone);
        setEmail(email);
        setCompanyName(companyName);
    }
<<<<<<< HEAD
    public Leads(SalesRep leadsListSR) {
        this.leadsListSR = leadsListSR;
=======
    public Leads(String namelead, String phoneLead, String emailLead, String companyLead, SalesRep salesRep) {
        setId(ID_STR + idCounter++);
        setName(name);
        setPhone(phone);
        setEmail(email);
        setCompanyName(companyName);
        setSalesRep(salesRep);
>>>>>>> origin
    }

    //Getters and Setters-------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String nameTrim = name.trim();
        if (nameTrim.split(" +").length == 2) {
            this.name = nameTrim;
        } else throw new IllegalArgumentException("The name should have First Name and Last Name");

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    /* ______________________________________________________________________________________ */
    /* ___________________________________METHODS____________________________________________ */
    /* ______________________________________________________________________________________ */

    @Override
    public String toString() {
        return "Leads{" + "id=" + id + ", name='" + name + '\'' + ", phone=" + phone + ", email='" + email + '\'' + ", companyName='" + companyName + '\'' + '}';
    }
}
