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
                "\n1. Type 'New Sales Rep' to add a new sales rep" +
                "\n2. Type 'Show Sales Rep' to see the list of sales rep " +
                "\n3.-Type 'New Lead' to add a new lead" +
                "\n4.-Type 'Show Leads' to see list of leads you already have." +
                "\n5.-Type 'Lookup lead <id>' to see to the info of an individual lead (<id> = id of the Lead)." +
                "\n6.-Type 'Convert <id>' to Contact to see the info of an individual contact (<id> = id of the lead). " +
                "\n7.-Type 'Create opportunity'" +
                "\n8.-Type 'show opportunity' to display the opportunities you already have" +
                "\n9.-Type 'opportunity status' to close the opportunity WON or LOST" +
                "\n10.-Type 'create account' to display the opportunities you already have" +
                "\n11.-Type 'show account' to display the opportunities you already have" +
                "\n12.-Type 'Quit' to close the application."

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
}
