package com.IronHach.CRM.CRM.models;

import com.IronHach.CRM.CRM.enums.Industry;
import com.IronHach.CRM.CRM.enums.Product;
import com.IronHach.CRM.CRM.enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.IronHach.CRM.CRM.models.Accounts.setCountryList;


public class Methods {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    private Leads lead;

    static Scanner scanner = new Scanner(System.in);

    static List<Leads> arrayOfLeads = new ArrayList<>();

    private Accounts accounts;

    static List<Accounts> arrayOfAcc = new ArrayList<>();

    private Opportunity opportunity;

    private Contact contact;
    static List<Opportunity> arrayOfOpps = new ArrayList<>();

    static Product product;
    static Industry industry;

    public Methods() {
    }

    ///////////////
    //LEADS METHODS
    ///////////////
    public static Leads generateNewLead() {
        String namelead = "";
        String phoneLead = "";
        String emailLead = "";
        String companyLead = "";
        while (namelead.split(" +").length < 2 || namelead.isEmpty()) {
            System.out.println("Please enter name and last name:");
            namelead = scanner.nextLine();
        }
        System.out.println("Please enter the phone:");
        phoneLead = scanner.nextLine();
        System.out.println(" Please enter the e-mail:");
        emailLead = scanner.nextLine();
        System.out.println("Please enter the company name:");
        companyLead = scanner.nextLine();

        Leads lead = new Leads(namelead, phoneLead, emailLead, companyLead);
        System.out.println("Your lead " + namelead.toUpperCase() + " was created successfully!!!");
        addLeadtoList(lead);
        return lead;
    }

    public static void addLeadtoList(Leads leadParam) {
        arrayOfLeads.add(leadParam);
    }


    public static void showLead() {
        if (arrayOfLeads.isEmpty()) {
            System.out.println("Sorry the list of leads is empty");
            String action = "";
            Boolean quitApp = true;

            while (quitApp) {
                action = Steps.menu();
                quitApp = Steps.actions(action);
                action = "";
            }
        } else {
            for (int i = 0; i < arrayOfLeads.size(); i++) {
                System.out.println(arrayOfLeads.get(i).getId() + " " + arrayOfLeads.get(i).getName());
            }
        }
    }

    public static void lookUpLead(String id) {
        String idInput = id.toUpperCase();
        for (int i = 0; i < arrayOfLeads.size(); i++) {
            if (arrayOfLeads.get(i).getId().equals(idInput)) {
                System.out.println(
                        "\nThe phone number is: "
                                + arrayOfLeads.get(i).getPhone()
                                + "\nThe email is: "
                                + arrayOfLeads.get(i).getEmail()
                                + "\nThe company name is: "
                                + arrayOfLeads.get(i).getCompanyName());
            }
        }
    }

    public static Contact convertIdLead(String idParam) {
        Contact contact = new Contact();
        for (int i = 0; i < arrayOfLeads.size(); i++) {
            if (idParam.equals(arrayOfLeads.get(i).getId())) {
                contact = new Contact(arrayOfLeads.get(i).getName(), arrayOfLeads.get(i).getPhone(), arrayOfLeads.get(i).getEmail(), arrayOfLeads.get(i).getCompanyName());
                System.out.println(arrayOfLeads.get(i).getPhone() + " " + arrayOfLeads.get(i).getEmail() + " " + arrayOfLeads.get(i).getCompanyName());
                arrayOfLeads.remove(i);
                System.out.println("The list of leads is know: " + arrayOfLeads.size());
                return contact;
            }
        }
        return contact;
    }

    // for the next week...
    /*public static String showStringId(String string) {
        String wordId = "";
        for (int i = 0; i < arrayOfLeads.size(); i++) {
            if (arrayOfLeads.get(i).getId().equals(string)) {
                wordId = arrayOfLeads.get(i).getId();
                return wordId;
            } else
                System.out.println("Lo has introducido mal");
        }
        return string;
    }*/


    /////////////////
    //ACCOUNT METHODS
    /////////////////

    public static Accounts convertToAccount() {
        String numEmployeesStr = "";
        int numEmployees;
        String city = "";
        String country = "";

        System.out.println("Please enter the of your industry:  PRODUCE,  ECOMMERCE,  MANUFACTURING,  MEDICAL,  OTHER,");
        industry = Industry.valueOf(scanner.next().toUpperCase());
        System.out.println("Please enter the number of employees");
        numEmployeesStr = scanner.next();
        numEmployees = Integer.parseInt(numEmployeesStr);
        System.out.println(" Please enter the City name:");
        city = scanner.next();
        System.out.println(" Please enter the Country name:");
        country = scanner.next();
        setCountryList(country);

        Accounts account = new Accounts(industry, numEmployees, city, country);
        addAccountToList(account);
        return account;

    }

    public static void addAccountToList(Accounts accParam) {
        arrayOfAcc.add(accParam);
    }


    public static void showAccount() {
        if (arrayOfAcc.isEmpty()) {
            throw new IllegalArgumentException("Sorry the list of accounts is empty");
        } else {
            for (int i = 0; i < arrayOfAcc.size(); i++) {
                System.out.println(arrayOfAcc.get(i));
            }
        }
    }

    ////////////////////
    //OPORTUNITY METHODS
    ////////////////////

    public static void addOppToList(Opportunity oppParam) {
        arrayOfOpps.add(oppParam);
    }

    public static void showOpportunity() {
        if (arrayOfOpps.isEmpty()) {
            throw new IllegalArgumentException("Sorry the list of opportunities is empty");
        } else {
            for (int i = 0; i < arrayOfOpps.size(); i++) {
                System.out.println(arrayOfOpps.get(i));
            }
        }
    }


    public static Opportunity generateNewOpp(Contact param) {
        String nameDm = "";
        String productToString;
        String quantityStr = "";
        int quantity = 0;

        while (nameDm.split(" +").length < 2 || nameDm.isEmpty()) {
            System.out.println("Please enter name and last name of the decision maker:");
            nameDm = scanner.nextLine();
        }

        do {
            System.out.println("Please enter the kind of product: Flatbed, Hybrid, Box");
            productToString = scanner.nextLine().toUpperCase();
        } while (!productToString.equals("BOX") && !productToString.equals("HYBRID") && !productToString.equals("FLATBED"));

        product = Product.valueOf(productToString);
        System.out.println("\033[0;1m" + ANSI_RED + "Please enter the quantity (Less than 1000): " + ANSI_RESET);
        quantityStr = scanner.next();
        quantity = Integer.parseInt(quantityStr);

        Opportunity opportunity = new Opportunity(nameDm, product, quantity, Status.OPEN, param);
        System.out.println("Your Opportunity " + nameDm.toUpperCase() + " was created successfully");

        addOppToList(opportunity);
        return opportunity;

    }


    public static void wonLooseOpp() {
        String inputId = "";
        String inputStatus = "";
        System.out.println("Write the ID of opportunity");
        inputId = scanner.next().toUpperCase();
        for (int i = 0; i < arrayOfOpps.size(); i++) {
            if (arrayOfOpps.get(i).getId().equals(inputId)) {
                System.out.println("You want " + Status.CLOSED_WON + " or " + Status.CLOSED_LOST + " this opportunity?");
                inputStatus = scanner.next().toUpperCase();
                arrayOfOpps.get(i).setStatus(Status.valueOf(inputStatus));
                System.out.println("Perfect, the Opportunity: " + inputId + "is closed: " + inputStatus);
                if (inputStatus.equals("CLOSED_LOST")) {
                    arrayOfOpps.remove(i);
                    System.out.println("The list of opportunities size is: " + arrayOfOpps.size());
                }
            } else {
                System.err.println("Try it again");
            }
        }

    }


}
