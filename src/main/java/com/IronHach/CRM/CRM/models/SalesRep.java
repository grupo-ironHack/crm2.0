package com.IronHach.CRM.CRM.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SalesRep {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //---------------------------------------------
    @OneToOne
    private Accounts accountsSR;

    @OneToMany (mappedBy = "opportunityListSR")
    private Set<Opportunity> arrayOfOpps;

    @OneToMany (mappedBy = "leadsListSR")
    private Set<Leads> arrayOfLeads;

    //---------------------------------------------


    public SalesRep() {
    }

    public SalesRep(Long id, String name, Accounts accountsSR, Set<Opportunity> arrayOfOpps, Set<Leads> arrayOfLeads) {
        this.id = id;
        this.name = name;
        this.accountsSR = accountsSR;
        this.arrayOfOpps = arrayOfOpps;
        this.arrayOfLeads = arrayOfLeads;
    }

    public SalesRep( String name) {
        this.name = name;
    }

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
        this.name = name;
    }

    public Accounts getAccountsSR() {
        return accountsSR;
    }

    public void setAccountsSR(Accounts accountsSR) {
        this.accountsSR = accountsSR;
    }

    public Set<Opportunity> getArrayOfOpps() {
        return arrayOfOpps;
    }

    public void setArrayOfOpps(Set<Opportunity> arrayOfOpps) {
        this.arrayOfOpps = arrayOfOpps;
    }

    public Set<Leads> getArrayOfLeads() {
        return arrayOfLeads;
    }

    public void setArrayOfLeads(Set<Leads> arrayOfLeads) {
        this.arrayOfLeads = arrayOfLeads;
    }
}


