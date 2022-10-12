package com.IronHach.CRM.CRM.models;

import com.IronHach.CRM.CRM.enums.Industry;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static final String ID_ACC= "AT-0";
    private static int idCounperAcc = 1;
    private String id;
    private Industry industry;
    private int numEmployees;

    private String city;

    private String country;

    //---------------------------------------------

    private static final String[] countryList = {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps",
            "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados",
            "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana",
            "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde",
            "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo",
            "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark",
            "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador",
            "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia",
            "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana",
            "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}",
            "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati",
            "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho",
            "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi",
            "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico",
            "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique",
            "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger",
            "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru",
            "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda",
            "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino",
            "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone",
            "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan",
            "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan",
            "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey",
            "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom",
            "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam",
            "Yemen", "Zambia", "Zimbabwe"};

    static Scanner scanner = new Scanner(System.in);
    public static List<Accounts> arrayOfAcc;
    //---------------------------------------------
    @OneToMany (mappedBy = "accountsOpps")
    List<Opportunity> oppsList;

    @OneToOne (mappedBy = "accountsContacts")
    private Contact contact;

    @OneToOne (mappedBy = "accountsSR")
    private SalesRep sr;


    @ManyToOne
    private SalesRep accountListSR;

    //Constructors--------------------------------

    public Accounts() {

    }

    public Accounts(Industry industry, int numEmployees, String city, String country) {
        setId(ID_ACC + idCounperAcc++);
        this.industry = industry;
        this.numEmployees = numEmployees;
        this.city = city;
        this.country = country;
    }

    public Accounts(Industry industry, int numEmployees, String city) {
        setId(ID_ACC + idCounperAcc++);
        setIndustry(industry);
        setNumEmployees(numEmployees);
        setCity(city);
    }

//Getters and Setters-------------------------

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        if(0 < numEmployees){
            this.numEmployees = numEmployees;
        } else throw new IllegalArgumentException("The number of employess on a company needs to be q ast least.");

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static String setCountryList(String country) {
        for (String a : countryList) {
            if (a.contains(country)) ;
            return a;
        } throw new IllegalArgumentException("Please select an existant currect Country");

    }


    /* ______________________________________________________________________________________ */
    /* ___________________________________METHODS____________________________________________ */
    /* ______________________________________________________________________________________ */

    @Override
    public String toString() {
        return "Accounts{" +
                "id='" + id + '\'' +
                ", industry=" + industry +
                ", numEmployees=" + numEmployees +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}