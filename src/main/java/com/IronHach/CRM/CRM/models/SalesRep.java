package com.IronHach.CRM.CRM.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static final String ID_STR = "SR-0";
    private static int idCounter = 1;
    private String id;

    private String name;

    @OneToOne
    private Accounts accountsSR;

    @OneToMany (mappedBy = "opportunityListSR")
    private List<Opportunity> arrayOfOpps;

    @OneToMany (mappedBy = "leadsListSR")
    private List<Leads> arrayOfLeads;
    public SalesRep(String name) {
        setId(ID_STR + idCounter++);
        setName(name);
    }

    public SalesRep() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


