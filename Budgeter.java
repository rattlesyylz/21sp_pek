// Cynthia Hong
// 4/27/2021 
// CSE142
// TA: Ana Jojic
// Take-home Assessment #4
//
/* This program, named Budgeter, will prompt a person for 
income and expense amounts, then calculate their net monthly 
income and leave some comments. */

import java.util.*;

public class Budgeter {
   // enter the total days of month
   public static final int DAYS_IN_MONTH = 31; 

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      // print the introduction part
      giveIntro();
      
      // ask for number of categories and each categorie's income
      // get total number of income for all categories
      double totalIncome = getAmount(console, "income");
      // ask for the choice by entering 1 or 2
      int numEnter = giveEnter(console);
      // ask for number of categories and each categorie's expense
      // get total number of expenses for all categories
      double totalExpense = getAmount(console, "expense");
      
      // calculate and print the total and average income and expenses
      // get netincome
      double netIncome = reportNum(totalIncome, totalExpense, numEnter);
      
      // calculate and report the netIncome
      // print the conclusion
      reportConclusion(netIncome);
   }
      
   // prints out a short introduction 
   // explains the purpose of the program
   public static void giveIntro() {
      System.out.println("This program asks for your monthly income and");
      System.out.println("expenses, then tells you your net monthly income.");
      System.out.println();
   }
   
   // reads in amount of money for this month
   // scanner console: the scanner to use for input
   // string typeName: the type of the money, income or expense
   // returns the value of totalAmount at the end of this method
   public static double getAmount(Scanner console, String typeName) {
      System.out.print("How many categories of " + typeName + "? ");
      int numCategories = console.nextInt();
      double totalAmount = 0.0;
      for (int i = 1; i <= numCategories; i++) {
         System.out.print("    Next " + typeName + " amount? $");
         double numAmount = console.nextDouble();
         totalAmount += numAmount;
      }
      System.out.println();
      return totalAmount;
   }
   
   // reads in 1 or 2 for the choice of expense
   // scanner console: the scanner to use for input
   // returns the value of numEnter at the end of this method
   public static int giveEnter(Scanner console) {
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      //enters 1 means choose monthly, and enter 2 means choose daily
      int numEnter = console.nextInt();
      return numEnter;
   }

   // Computes and prints the final numbers of the total and average amount. 
   // double totalIncome: the total amount of imcome per month
   // double totalExpense: the total amount of expense per month or day
   // int numEnter: the choice for monthly or daily expenses
   // returns the value of netIncome for monthly at the end of this method
   public static double reportNum(double totalIncome, double totalExpense, int numEnter) {
      double averIncome = round2(totalIncome / DAYS_IN_MONTH);
      System.out.println("Total income = $" + round2(totalIncome) + 
              " ($" + averIncome + "/day)");
      if (numEnter == 1) {
         double averExpense = round2(totalExpense / DAYS_IN_MONTH);
         System.out.println("Total expenses = $" + round2(totalExpense) + 
                 " ($" + averExpense + "/day)");
      } else {
         double totalMonthExpense = round2(totalExpense * DAYS_IN_MONTH);
         System.out.println("Total expenses = $" + round2(totalMonthExpense) + 
                 " ($" + totalExpense + "/day)");
         totalExpense=totalMonthExpense;
      }
      double netIncome = round2(totalIncome) - round2(totalExpense);
      return netIncome;
   }   
   
   // prints the netIncome, a conclusion, and a message
   // double netIncome: the difference between total income and expenses per month
   public static void reportConclusion(double netIncome) {
      System.out.println();
      spendOrSave(netIncome); //report the netIncome
      if (netIncome > 250.00) {
         System.out.println("You're a big saver.");
         System.out.println("Please make persistent efforts!");
      } else if (netIncome > 0.00) {
         System.out.println("You're a saver.");
         System.out.println("Please save more next month!");
      } else if (netIncome > -250.00) {
         System.out.println("You're a spender.");
         System.out.println("Only buy the necessities you need!");
      } else {
         System.out.println("You're a big spender.");
         System.out.println("Please don't open your wallet!");
      }
   }

   // prints the first sentence of the conclusion
   // ruduces the redunancy in the conclusion
   // double netincome: the difference between total income and expenses per month
   public static void spendOrSave(double netIncome) {
      if (netIncome > 0) {
         System.out.println("You earned $" + round2(netIncome) +
                 " more than you spent this month.");
      } else {
         System.out.println("You spent $" + round2(-netIncome) +
                 " more than you earned this month.");
      }
   }

   // Rounds the given number to 2 decimal places and returns it
   // double num: the number to be rounded
   public static double round2(double num) {
      return Math.round(num * 100.0) / 100.0;
   }
}
