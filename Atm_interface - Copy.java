package com.OIBSIP;

import java.util.ArrayList;
import java.util.Scanner;

public class Atm_interface {
        public static Scanner sc = new Scanner(System.in);
        public static ArrayList<String> list = new ArrayList<>();

        // "transac" function displays the transaction history for the user
        public static void transac(int balance) {
            for (String i : list) {
                System.out.println(i);
            }
            ask(balance);
        }

        // "login" function checks if the given username and pin are valid
        public static void login(String username, int pin) {
            if (username.contains("Tom") && pin == 1001) {
                list.add("Logged in");
                ask(5000);
            } else {
                System.out.println("Enter valid information!");
                System.out.print("Username followed by pin seperated with a space: ");
                login(sc.next(), sc.nextInt());
            }
        }

        // "withdraw" function allows the user to withdraw a specified amount from his account

        public static void withdraw(int balance, int amount) {
            if (amount <= balance && amount >= 0) {
                balance = balance - amount;
                System.out.println("Transaction successful \n Current balance is " + balance);
                list.add("Rupee/'s " + amount + " withdrawn.");
                ask(balance);
            } else {
                System.out.print("Enter a valid amount(greater than equal to zero): ");
                withdraw(balance, sc.nextInt());
            }
        }

        // "deposit" to deposit a specified amount into their account
        public static void deposit(int balance, int amount) {
            if (amount >= 0) {
                balance =balance + amount;
                System.out.println("Transaction successful \n Current balance is " + balance);
                list.add(amount + " Rupee/'s deposited!");
                ask(balance);
            } else {
                System.out.print("Enter a valid amount(greater than equal to zero): ");
                deposit(balance, sc.nextInt());
            }
        }

        // "transfer" function allows the user to transfer a specified amount to another user's account
        public static void transfer(int balance, int amount) {
            if ((amount <= balance) && (amount >= 0)) {
                System.out.print("Enter receiver's username: ");
                String accname = sc.next();
                balance = balance - amount;
                System.out.println(amount + " Rupee/s sent to " + accname);
                System.out.println("Transaction successful \n Current balance is " + balance);
                list.add(amount + " transferred to account " + accname);
                ask(balance);
            } else {
                System.out.print("Enter a valid amount(greater than equal to zero): ");
                transfer(balance, sc.nextInt());
            }
        }

        // "quit" to exit the program
        public static void quit(int balance, char qresponse) {
            if (qresponse == 'y' || qresponse == 'Y') {
                System.out.println("---------------Logged out---------------");
                System.out.println();
            } else
                ask(balance);
        }

        // "ask" function presents the user with a list of options and allows them to choose one of the actions
        public static void ask(int bal) {
            System.out.println("----------------------------------------");
            System.out.println();
            System.out.println("1) Transaction History");
            System.out.println("2) Withdraw");
            System.out.println("3) Deposit");
            System.out.println("4) Transfer");
            System.out.println("5) Quit");
            System.out.print("Choose one of the following actions: ");
            int opt = sc.nextInt();
            System.out.println();
            if (1 > opt || opt > 5) {
                System.out.println("Enter valid input!");
                ask(bal);
            } else {
                switch (opt) {
                    case 1:
                        System.out.println("----------Transaction history!----------");
                        transac(bal);
                        break;

                    case 2:
                        System.out.print("Enter amount to be withdrawn: ");
                        withdraw(bal, sc.nextInt());
                        break;

                    case 3:
                        System.out.print("Enter amount to be deposited: ");
                        deposit(bal, sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter amount to be transfered: ");
                        transfer(bal, sc.nextInt());
                        break;

                    case 5:
                        System.out.print("Do you want to exit?(Yes/No): ");
                        char qresponse = sc.next().charAt(0);
                        quit(bal, qresponse);
                        break;
                }
            }
        }

        public static void main(String[] args) {
            System.out.println();
            // Use username as Given 'Tom'
            System.out.println("Use pin as '1001' for testing!");
            System.out.println("---------------**Login**---------------");
            System.out.print("Enter user name: ");
            String username = sc.next();
            System.out.print("Enter pin: ");
            int pin = sc.nextInt();
            login(username, pin);
        }
    }




