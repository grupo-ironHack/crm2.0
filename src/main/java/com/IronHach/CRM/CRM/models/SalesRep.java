package com.IronHach.CRM.CRM.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static final String ID_STR = "SR-0";
    private static int idCounter = 1;
    private String id;

    private String name;
}


