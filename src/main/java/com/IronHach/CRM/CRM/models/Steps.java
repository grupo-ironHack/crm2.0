package com.IronHach.CRM.CRM.models;

import java.util.Scanner;

public class Steps {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    static Scanner scanner = new Scanner(System.in);
    static String userInput = "";
    static String menuInput = "";
    static Contact infoContact = new Contact();

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
        System.out.println(ANSI_RED_BACKGROUND + "                        * CRM APPLICATION *                          " + ANSI_RED_BACKGROUND + ANSI_RESET);
        System.out.println(ANSI_YELLOW +
                "\n                 PLEASE TYPE WHAT DO YOU WANT TO DO" + ANSI_YELLOW +
                "\n---------------------------------------------------------------------" + ANSI_RESET +
                "\n1.-Type 'New Lead' to add a new lead." +
                "\n2.-Type 'Show Leads' to see list of leads you already have." +
                "\n3.-Type 'Lookup lead <id>' to see to the info of an individual lead (<id> = id of the Lead)." +
                "\n4.-Type 'Convert <id>' to Contact to see the info of an individual contact (<id> = id of the lead). " +
                "\n5.-Type 'Create opportunity'" +
                "\n6.-Type 'show opportunity' to display the opportunities you already have." +
                "\n7.-Type 'opportunity status' to close the opportunity WON or LOST." +
                "\n8.-Type 'create account' to display the opportunities you already have." +
                "\n9.-Type 'show account' to display the opportunities you already have." +
                "\n9.-Type 'Reporting Functionality' to display Reporting Functionality 📈 menu." +
                "\n42.-Type 'Quit' to close the application."
        );
        while (answermenuInput.isEmpty()) {
            answermenuInput = scanner.nextLine();
            if (answermenuInput.isEmpty()) {
                System.out.println("Please verify you type the action correctly");
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
                System.out.println("please type the correct action you want to do");
                return true;
        }
    }


    public static void reports() {

    }

    public static void menuReports(){
        String answermenuInput = "";
        System.out.println(ANSI_RED_BACKGROUND + "                        * CRM APPLICATION *                          " + ANSI_RED_BACKGROUND + ANSI_RESET);
        System.out.println(ANSI_YELLOW +
                "\n                 PLEASE TYPE WHAT DO YOU WANT TO DO" + ANSI_YELLOW +
                "\n---------------------------------------------------------------------" + ANSI_RESET +
                "\n - - - - - - - - - -  Reporting Functionality 📈- - - - - - - - - - - -" +
                "\n -   -   -   -   -   -   -   - SalesRep  📊 -   -   -   -   -   -   -   -" +
                "\n10.-Type 'Report Lead by SalesRep' to display the count of Leads by SalesRep." +
                "\n11.-Type 'Report Opportunity by SalesRep' to display count of all Opportunities by SalesRep." +
                "\n12.-Type 'Report CLOSED-WON by SalesRep' to display the count of all CLOSED_WON Opportunities by SalesRep. " +
                "\n13.-Type 'Report CLOSED-LOST by SalesRep' to display the count of all CLOSED_LOST Opportunities by SalesRep." +
                "\n14.-Type 'Report OPEN by SalesRep' to display the count of all OPEN Opportunities by SalesRep." +
                "\n -   -   -   -   -   -   -   - Product 📦 -   -   -   -   -   -   -   -" +
                "\n15.-Type 'Report Opportunity by the product' to display the count of all Opportunities by the product." +
                "\n16.-Type 'Report CLOSED-WON by the product' to display count of all CLOSED_WON Opportunities by the product." +
                "\n17.-Type 'Report CLOSED-LOST by the product' to display the count of all CLOSED_LOST Opportunities by the product." +
                "\n18.-Type 'Report OPEN by the product' to display the count of all OPEN Opportunities by the product." +
                "\n -   -   -   -   -   -   -   - Country 📍 -   -   -   -   -   -   -   -" +
                "\n19.-Type 'Report Opportunity by Country' to display the count of all Opportunities by country." +
                "\n20.-Type 'Report CLOSED-WON by Country' to display the count of all CLOSED_WON Opportunities by country." +
                "\n21.-Type 'Report CLOSED-LOST by Country' to display the count of all CLOSED_LOST Opportunities by country." +
                "\n22.-Type 'Report OPEN by Country' to display the count of all OPEN Opportunities by country." +
                "\n -   -   -   -   -   -   -   -  City 🏢  -   -   -   -   -   -   -   -" +
                "\n23.-Type 'Report Opportunity by City' to display the count of all Opportunities by the city." +
                "\n24.-Type 'Report CLOSED-WON by City' to display the count of all CLOSED_WON Opportunities by the city." +
                "\n25.-Type 'Report CLOSED-LOST by City' to display the count of all CLOSED_LOST Opportunities by the city." +
                "\n26.-Type 'Report OPEN by City' to display the count of all OPEN Opportunities by the city." +
                "\n -   -   -   -   -   -   -    Industry  ⚙️   -   -   -   -   -   -   -" +
                "\n27.-Type 'Report Opportunity by Industry' to display the count of all Opportunities by industry." +
                "\n28.-Type 'Report CLOSED_WON by Industry' to display the count of all CLOSED_WON Opportunities by industry." +
                "\n29.-Type 'Report CLOSED_LOST by Industry' to display the count of all CLOSED_LOST Opportunities by industry." +
                "\n30.-Type 'Report OPEN by Industry' to display the count of all OPEN Opportunities by industry." +
                "\n -   -   -   -   -   -   -  EmployeeCount 👩🏽‍💼🧑🏻‍💼 -   -   -   -   -   -   -" +
                "\n30.-Type 'Mean EmployeeCount' to display the mean employeeCount." +
                "\n31.-Type 'Median EmployeeCount' to display the median employeeCount." +
                "\n32.-Type 'Max EmployeeCount' to display the maximum employeeCount." +
                "\n33.-Type 'Min EmployeeCount' to display the minimum employeeCount." +
                "\n -   -   -   -   -   -   -    Quantity  🧮📦   -   -   -   -   -   -   -" +
                "\n34.-Type 'Mean Quantity' to display the mean products order." +
                "\n35.-Type 'Median Quantity' to display the minimum products order." +
                "\n36.-Type 'Max Quantity' to display the minimum products order." +
                "\n37.-Type 'Min Quantity' to display the minimum products order." +
                "\n -   -   -   -   -   -   -   Opportunity 🛒  -   -   -   -   -   -   -" +
                "\n38.-Type 'Mean Opps per Account”' to display the mean of Opportunities associated with an Account." +
                "\n39.-Type 'Median Opps per Account”' to display the minimum of Opportunities associated with an Account." +
                "\n40.-Type 'Max Opps per Account”' to display the minimum of Opportunities associated with an Account." +
                "\n41.-Type 'Min Opps per Account”' to display the minimum of Opportunities associated with an Account." +
                "\n41.-Type 'main menu”' to display the main menu" +
                "\n42.-Type 'Quit' to close the application."
        );
        while (answermenuInput.isEmpty()) {
            answermenuInput = scanner.nextLine();
            if (answermenuInput.isEmpty()) {
                System.out.println("Please verify you type the action correctly");
            }
        }
        //return answermenuInput;
    }


}
