package com.IronHach.CRM.CRM.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static final String ID_STR = "SR-0";
    private static int idCounter = 1;
    private String id;

    private String name;

    //---------------------------------------------
    @OneToMany (mappedBy = "accountListSR")
    private Set<Accounts> arrayOfAcc;

    @OneToMany (mappedBy = "opportunityListSR")
    private Set<Opportunity> arrayOfOpps;

    @OneToMany (mappedBy = "leadsListSR")
    private Set<Leads> arrayOfLeads;

    //---------------------------------------------


    public SalesRep() {
    }

    public SalesRep(String id, String name, Set<Accounts> arrayOfAcc, Set<Opportunity> arrayOfOpps, Set<Leads> arrayOfLeads) {
        this.id = id;
        this.name = name;
        this.arrayOfAcc = arrayOfAcc;
        this.arrayOfOpps = arrayOfOpps;
        this.arrayOfLeads = arrayOfLeads;
    }
}


