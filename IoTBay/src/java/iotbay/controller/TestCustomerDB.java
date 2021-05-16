/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import customer.Customer;
import iotbay.model.dao.*;

public class TestCustomerDB {

    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DBCustomerManager db;

    public static void main(String[] args) throws SQLException {
        (new TestCustomerDB()).runQueries();
    }

    public TestCustomerDB() {
        try {
            connector = new DBConnector();
            conn = connector.connection();
            db = new DBCustomerManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestCustomerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private char readChoice() {
        System.out.print("CRUDS OR * TO EXIT:");
        return Character.toUpperCase(in.nextLine().charAt(0));
    }

    private void runQueries() throws SQLException {
        char c;
        while ((c = readChoice()) != '*') {
            switch (c) {
                case 'C':
                    addCustomer();
                    break;
                case 'R':
                    readCustomer();
                    break;
                case 'U':
                    updateCustomer();
                    break;
                case 'D':
                    deleteCustomer();
                    break;
                case 'S':
                    listCustomer();
                    break;
                case '*':
                    addCustomer();
                    break;
                default:
                    System.out.println("UNKNOWN COMMAND");
            }
        }
    }

    private void addCustomer() {
        System.out.print("First name: ");
        String first = in.nextLine();
        System.out.print("Last name: ");
        String last = in.nextLine();
        System.out.print("CUSTOMER email: ");
        String email = in.nextLine();
        System.out.print("CUSTOMER password: ");
        String password = in.nextLine();
        System.out.print("CUSTOMER gender: ");
        String gender = in.nextLine();
        System.out.print("CUSTOMER address: ");
        String address = in.nextLine();
        System.out.print("CUSTOMER date of birth: ");
        String dob = in.nextLine();
        System.out.print("CUSTOMER number: ");
        String number = in.nextLine();
        System.out.print("CUSTOMER subscription: ");
        String sub = in.nextLine();
        try {
            db.addCustomer(first, last, email, password, gender, address, number);
        } catch (SQLException ex) {
            Logger.getLogger(TestCustomerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("CUSTOMER is added to the database.");
    }

    private void readCustomer() throws SQLException {
        System.out.print("CUSTOMER email: ");
        String email = in.nextLine();
        System.out.print("CUSTOMER password:");
        String password = in.nextLine();
        Customer customer = db.findCustomer(email, password);
        if (customer != null) {
            String name = customer.getFirstName();
            System.out.println("Customer " + name + " exists in the system");
        } else {
            System.out.println("Customer does not exist in the system");
        }
    }

        private void findCustomer() throws SQLException {
        System.out.print("CUSTOMER email: ");
        String email = in.nextLine();
        System.out.print("CUSTOMER password:");
        String password = in.nextLine();
        Customer customer = db.findCustomer(email, password);
        if (customer != null) {
            String name = customer.getFirstName();
            System.out.println("Customer " + name + " exists in the system");
        } else {
            System.out.println("Customer does not exist in the system");
        }
    }
        
    private void updateCustomer() {
        System.out.print("CUSTOMER id: ");
        String id = in.nextLine();

        try {
            if (db.checkCustomer(id)) {
                System.out.println("Customer found, enter new info");
                System.out.print("First name: ");
                String first = in.nextLine();
                System.out.print("Last name: ");
                String last = in.nextLine();
                System.out.print("CUSTOMER email: ");
                String email = in.nextLine();
                System.out.print("CUSTOMER password: ");
                String password = in.nextLine();
                System.out.print("CUSTOMER gender: ");
                String gender = in.nextLine();
                System.out.print("CUSTOMER address: ");
                String address = in.nextLine();
                System.out.print("CUSTOMER date of birth: ");
                String dob = in.nextLine();
                System.out.print("CUSTOMER number: ");
                String number = in.nextLine();
                System.out.print("CUSTOMER subscription: ");
                String sub = in.nextLine();
                db.updateCustomer(id, first, last, email, password, gender, address, number);
            } else {
                System.out.println("Customer not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestCustomerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteCustomer() {
        System.out.print("CUSTOMER id: ");
        String id = in.nextLine();

        try {
            if (db.checkCustomer(id)) {
                db.deleteCustomer(id);
                System.out.println("Customer found, deleting record");
            } else {
                System.out.println("Customer not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestCustomerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listCustomer() {
        try {
            ArrayList<Customer> customers = db.fetchCustomers();
            System.out.println("CUSTOMERS TABLE:");
            customers.stream().forEach((customer) -> {
                System.out.printf("%-10s %-15s %-15s %-20s %-15s %-8s %-40s %-15s %-15s %-15s\n", customer.getUserID(), customer.getFirstName(), customer.getLastName(), customer.geteMail(), customer.getPassword(), customer.getGender(), customer.getAddress(), customer.getPhoneNumber(), customer.isSubscription());
            });
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(TestCustomerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}