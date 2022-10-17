package com.IronHach.CRM.CRM.models;

import com.IronHach.CRM.CRM.Repositories.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

public class Steps {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    static Scanner scanner = new Scanner(System.in);
    static String userInput = "";
    static String menuInput = "";
    static String actionInputReport = "";
    static Contact infoContact = new Contact();

    //static OpportunityRepository opportunityRepository;

    @Autowired
    static
    OpportunityRepository opportunityRepository;

    public static void greeting() {
        System.out.println(ANSI_RED_BACKGROUND + "                        * CRM APPLICATION *                          " + ANSI_RED_BACKGROUND + ANSI_RESET);
        System.out.println("\033[0;1m" + ANSI_BLUE + " If says type 'New Lead', just type that words, not numbers" +
                "\n " +
                "\n In the id steps, the ID start with 2 characters, the first one of the word and the last one. For example:" +
                "\n " +
                "\n LOOKUP LEAD <ID> the ID makes references to L because is the first character and D because is the last one " +
                "\n" + ANSI_RED + "For example, for looking up the first LEAD Id will be: LD-01, the Account Id will be: AT-01, etc" +
                "\n⚠️       PLEASE FOLlOW THE CORRECT INSTRUCTIONS      ⚠️" +
                "\n " + ANSI_RESET +
                "\n " + "    ===> ️NOW, YOU'RE READY. LET'S START⭐️💥 <===")

        ;
        while (userInput.isEmpty()) {
            System.out.println("Please enter your name");
            userInput = scanner.nextLine().trim();
        }
        System.out.println("WELCOME " + userInput.toUpperCase());
    }


    public static String menu() {
        String answermenuInput = "";
        System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "                        * CRM APPLICATION *                          " + ANSI_RESET + ANSI_RESET);
        System.out.println(ANSI_YELLOW +
                "\n                 PLEASE TYPE WHAT DO YOU WANT TO DO" + ANSI_YELLOW +
                "\n---------------------------------------------------------------------" + ANSI_RESET +
                "\n1.-Type 'New Sales Rep' to add a new salesRep." +
                "\n2.-Type 'Show Sales Rep' to see list of salesRep you already have." +
                "\n3.-Type 'New Lead' to add a new lead." +
                "\n4.-Type 'Show Leads' to see list of leads you already have." +
                "\n5.-Type 'Lookup lead <id>' to see to the info of an individual lead (<id> = id of the Lead)." +
                "\n6.-Type 'Convert <id>' to Contact to see the info of an individual contact (<id> = id of the lead). " +
                "\n7.-Type 'Create opportunity'" +
                "\n8.-Type 'show opportunity' to display the opportunities you already have." +
                "\n9.-Type 'opportunity status' to close the opportunity WON or LOST." +
                "\n10.-Type 'create account' to display the opportunities you already have." +
                "\n11.-Type 'show account' to display the opportunities you already have." +
                "\n12.-Type 'Reporting Functionality' to display Reporting Functionality 📈 menu." +
                "\n13.-Type 'Quit' to close the application."
        );
        while (answermenuInput.isEmpty()) {
            answermenuInput = scanner.nextLine();
            if (answermenuInput.isEmpty()) {
                System.out.println("⚠️Please verify you type the action correctly");
            }
        }
        return answermenuInput;
    }

    public static Boolean actions(String inputTyped) {
        String input = inputTyped.toLowerCase();
        if (input.contains("lookup lead")) {
            input = input.substring(0, 11);
        }
        if (input.contains("convert")) {
            input = input.substring(0, 7);
        }


        switch (input) {
            case "new sales rep":
                System.out.println("You type New sales rep");
                Methods.generateNewSalesRep();
                return true;
            case "show sales rep":
                System.out.println("You type Show sales rep");
                Methods.showSalesRep();
            case "new lead":
                System.out.println("You type New lead");
                Methods.generateNewLead();
                return true;
            case "show leads":
                System.out.println("You type Show leads");
                Methods.showLead();
                return true;
            case "lookup lead":
                System.out.println("You type Look up lead");
                String idsplit = inputTyped.toUpperCase().substring(11, 17).trim();
                Methods.lookUpLead(idsplit);
                return true;
            case "convert":
                System.out.println("You type convert id");
                String idsplitConvertId = inputTyped.toUpperCase().substring(8).trim();
                infoContact = Methods.convertIdLead(idsplitConvertId);
                System.out.println("Convert lead successfully!!!!");
                return true;
            case "create opportunity":
                System.out.println("You type create opportunity");
                Methods.generateNewOpp(infoContact);
                System.out.println("Create opportunity successfully!!!!");
                return true;
            case "show opportunity":
                System.out.println("You type show opportunity");
                Methods.showOpportunity();
                return true;
            case "opportunity status":
                System.out.println("You type Opportunity status");
                Methods.wonLooseOpp();
                return true;
            case "create account":
                System.out.println("You type  Create account");
                Methods.convertToAccount();
                System.out.println("Create account successfully!!!!");
            case "show account":
                System.out.println("You type show account");
                Methods.showAccount();
                return true;
            case "reporting functionality":
                System.out.println("You type reporting functionality");
                reports();
                return true;
            case "quit":
                System.out.println("\033[0;1m" + "You type quit");
                System.out.println("\033[0;1m" + "Thanks for  using CRM APP");
                System.out.println("\033[0;1m" + ANSI_BLUE_BACKGROUND + "Develop by, Pol, Diana y Yehosuá");
                return false;
            default:
                System.out.println("⚠️please type the correct action you want to do");
                return true;
        }
    }


    public static void reports() {

        boolean quitMenuReport = true;
        while (quitMenuReport) {
            actionInputReport = menuReports();
            quitMenuReport = actionsReport(actionInputReport);
            actionInputReport = "";
        }


    }

    // ANSI_BLUE_BACKGROUND
    public static String menuReports() {
        String answermenuInput = "";
        System.out.println(ANSI_BLUE_BACKGROUND + "                         " +
                ANSI_BLACK + "   Reporting Functionality 📈   " + ANSI_RESET + ANSI_BLUE_BACKGROUND + "                                 " + ANSI_RESET +
                ANSI_YELLOW + "\n                    PLEASE TYPE WHAT DO YOU WANT TO DO" + ANSI_YELLOW + ANSI_RESET +
                ANSI_GREEN + "\n -   -   -   -   -   -   -   - SalesRep  📊 -   -   -   -   -   -   -   -" + ANSI_RESET +
                "\n1.-Type 'Report Lead by SalesRep' to display the count of Leads by SalesRep." +
                "\n2.-Type 'Report Opportunity by SalesRep' to display count of all Opportunities by SalesRep." +
                "\n3.-Type 'Report CLOSED-WON by SalesRep' to display the count of all CLOSED_WON Opportunities by SalesRep. " +
                "\n4.-Type 'Report CLOSED-LOST by SalesRep' to display the count of all CLOSED_LOST Opportunities by SalesRep." +
                "\n5.-Type 'Report OPEN by SalesRep' to display the count of all OPEN Opportunities by SalesRep." +
                ANSI_GREEN + "\n -   -   -   -   -   -   -   - Product 📦 -   -   -   -   -   -   -   -" + ANSI_RESET +
                "\n6.-Type 'Report Opportunity by product' to display the count of all Opportunities by the product." +
                "\n7.-Type 'Report CLOSED-WON by product' to display count of all CLOSED_WON Opportunities by the product." +
                "\n8.-Type 'Report CLOSED-LOST by product' to display the count of all CLOSED_LOST Opportunities by the product." +
                "\n9.-Type 'Report OPEN by the product' to display the count of all OPEN Opportunities by the product." +
                ANSI_GREEN + "\n -   -   -   -   -   -   -   - Country 📍 -   -   -   -   -   -   -   -" + ANSI_RESET +
                "\n10.-Type 'Report Opportunity by Country' to display the count of all Opportunities by country." +
                "\n11.-Type 'Report CLOSED-WON by Country' to display the count of all CLOSED_WON Opportunities by country." +
                "\n12.-Type 'Report CLOSED-LOST by Country' to display the count of all CLOSED_LOST Opportunities by country." +
                "\n13.-Type 'Report OPEN by Country' to display the count of all OPEN Opportunities by country." +
                ANSI_GREEN + "\n -   -   -   -   -   -   -   -  City 🏢  -   -   -   -   -   -   -   -" + ANSI_RESET +
                "\n14.-Type 'Report Opportunity by City' to display the count of all Opportunities by the city." +
                "\n15.-Type 'Report CLOSED-WON by City' to display the count of all CLOSED_WON Opportunities by the city." +
                "\n16.-Type 'Report CLOSED-LOST by City' to display the count of all CLOSED_LOST Opportunities by the city." +
                "\n17.-Type 'Report OPEN by City' to display the count of all OPEN Opportunities by the city." +
                ANSI_GREEN + "\n -   -   -   -   -   -   -    Industry  ⚙️   -   -   -   -   -   -   -" + ANSI_RESET +
                "\n18.-Type 'Report Opportunity by Industry' to display the count of all Opportunities by industry." +
                "\n19.-Type 'Report CLOSED_WON by Industry' to display the count of all CLOSED_WON Opportunities by industry." +
                "\n20.-Type 'Report CLOSED_LOST by Industry' to display the count of all CLOSED_LOST Opportunities by industry." +
                "\n21.-Type 'Report OPEN by Industry' to display the count of all OPEN Opportunities by industry." +
                ANSI_GREEN + "\n -   -   -   -   -   -   -  EmployeeCount 👩🏽‍💼🧑🏻‍💼 -   -   -   -   -   -   -" + ANSI_RESET +
                "\n22.-Type 'Mean EmployeeCount' to display the mean employeeCount." +
                "\n23.-Type 'Median EmployeeCount' to display the median employeeCount." +
                "\n24.-Type 'Max EmployeeCount' to display the maximum employeeCount." +
                "\n25.-Type 'Min EmployeeCount' to display the minimum employeeCount." +
                ANSI_GREEN + "\n -   -   -   -   -   -   -    Quantity  🧮📦   -   -   -   -   -   -   -" + ANSI_RESET +
                "\n26.-Type 'Mean Quantity' to display the mean products order." +
                "\n27.-Type 'Median Quantity' to display the minimum products order." +
                "\n28.-Type 'Max Quantity' to display the minimum products order." +
                "\n29.-Type 'Min Quantity' to display the minimum products order." +
                ANSI_GREEN + "\n -   -   -   -   -   -   -   Opportunity 🛒  -   -   -   -   -   -   -" + ANSI_RESET +
                "\n30.-Type 'Mean Opps per Account' to display the mean of Opportunities associated with an Account." +
                "\n31.-Type 'Median Opps per Account' to display the minimum of Opportunities associated with an Account." +
                "\n32.-Type 'Max Opps per Account' to display the minimum of Opportunities associated with an Account." +
                "\n33.-Type 'Min Opps per Account' to display the minimum of Opportunities associated with an Account." +
                "\n34.-Type 'Main menu' to go back ⏮ and display the main menu  " + ANSI_WHITE_BACKGROUND + ANSI_BLACK + "   - CRM Application -   " + ANSI_RESET + ANSI_RESET
        );
        while (answermenuInput.isEmpty()) {
            answermenuInput = scanner.nextLine();
            if (answermenuInput.isEmpty()) {
                System.out.println("⚠️ Please verify you type the correctly the action you want to do️");
            }
        }
        return answermenuInput;
    }
    public static Boolean actionsReport(String inputTyped) {

        String input = inputTyped.toLowerCase();
        switch (input) {
            // ------------------------------SalesRep------------------------------------------------
            case "report lead by salesrep":
                System.out.println("You type Report Lead by SalesRep");
                return true;
            case "report opportunity by salesrep":
                System.out.println("You type Report Opportunity by SalesRep");
                return true;
            case "report closed-won by salesrep":
                System.out.println("You type Report CLOSED-WON by SalesRep");
                return true;
            case "report closed-lost by salesrep":
                System.out.println("You type Report CLOSED-LOST by SalesRep");
                return true;
            case "report open by salesrep":
                System.out.println("You type Report OPEN by SalesRep");
                return true;
            // ------------------------------Product------------------------------------------------
            case "report opportunity by product":
                System.out.println("You type Report Opportunity by product");
                /*List<Object[]> result = */opportunityRepository.countByProduct();
                //System.out.println(result);
                System.out.println("YA PASé POR EL MëTODOS DEL REPOSITORIO");
                return true;
            case "report closed-won by product":
                System.out.println("You type Report CLOSED-WON by product");
                return true;
            case "report closed-lost by product":
                System.out.println("You type Report CLOSED-LOST by product");
                return true;
            case "report open by product":
                System.out.println("You type Report OPEN by product");
                return true;
            // -----------------------------Country-------------------------------------------------
            case "report opportunity by country":
                System.out.println("You type Report Opportunity by country");
                return true;
            case "report closed-won by country":
                System.out.println("You type Report CLOSED-WON by country");
                return true;
            case "report closed-lost by country":
                System.out.println("You type Report CLOSED-LOST by country");
                return true;
            case "report open by country":
                System.out.println("You type Report OPEN by country");
                return true;
            // -----------------------------City-------------------------------------------------
            case "report opportunity by city":
                System.out.println("You type Report Opportunity by city");
                return true;
            case "report closed-won by city":
                System.out.println("You type Report CLOSED-WON by city");
                return true;
            case "report closed-lost by city":
                System.out.println("You type Report CLOSED-LOST by city");
                return true;
            case "report open by city":
                System.out.println("You type Report OPEN by city");
                return true;
            // -----------------------------Industry-------------------------------------------------
            case "report opportunity by industry":
                System.out.println("You type Report Opportunity by industry");
                return true;
            case "report closed-won by industry":
                System.out.println("You type Report CLOSED-WON by industry");
                return true;
            case "report closed-lost by industry":
                System.out.println("You type Report CLOSED-LOST by industry");
                return true;
            case "report open by industry":
                System.out.println("You type Report OPEN by industry");
                return true;
            // -----------------------------EmployeeCount-------------------------------------------------
            case "mean employeecount":
                System.out.println("You type Mean EmployeeCount");
                return true;
            case "median employeecount":
                System.out.println("You type Median EmployeeCount");
                return true;
            case "max employeecount":
                System.out.println("You type Max EmployeeCount");
                return true;
            case "min employeecount":
                System.out.println("You type Min EmployeeCount");
                return true;
            // -----------------------------Quantity-------------------------------------------------
            case "mean quantity":
                System.out.println("You type Mean Quantity");
                return true;
            case "median quantity":
                System.out.println("You type Median Quantity");
                return true;
            case "max quantity":
                System.out.println("You type Max Quantity");
                return true;
            case "min quantity":
                System.out.println("You type Min Quantity");
                return true;
            // -----------------------------Opportunity-------------------------------------------------
            case "mean opps per account":
                System.out.println("You type Mean Opps per Account");
                return true;
            case "median opps per account":
                System.out.println("You type Median Opps per Account");
                return true;
            case "max opps per account":
                System.out.println("You type Max Opps per Account");
                return true;
            case "min opps per account":
                System.out.println("You type Min Opps per Account");
                return true;
            // ------------------------------------------------------------------------------
            case "main menu":
                System.out.println("\033[0;1m" + "You quit the Reporting Functionality Menu");
                return false;
            default:
                System.out.println("⚠️please type the correct action you want to do");
                return true;
        }

    }

}

