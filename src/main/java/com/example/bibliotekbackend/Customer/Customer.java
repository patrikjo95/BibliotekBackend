package com.example.bibliotekbackend.Customer;

public class Customer {
    // private int ID_customer;
    private String customer_pnr;
    private String customer_pin;
    private String ISBN_book;



    /*
    public Customer(int ID_customer, String customer_pnr, String customer_pin) {
        this.ID_customer = ID_customer;
        this.customer_pnr = customer_pnr;
        this.customer_pin = customer_pin;
    }

     */

    public Customer(String customer_pnr, String customer_pin) {
        this.customer_pnr = customer_pnr;
        this.customer_pin = customer_pin;
    }

    public Customer(String customer_pnr, String customer_pin, String ISBN_book) {
        this.customer_pnr = customer_pnr;
        this.customer_pin = customer_pin;
        this.ISBN_book = ISBN_book;
    }


    /*
    public Customer(String customer_pnr_live, String ISBN_book_live) {
        this.customer_pnr = customer_pnr_live;
        this.ISBN_book_live = ISBN_book_live;
    }
     */


    public static Customer createCustomer(String customer_pnr, String customer_pin, String ISBN_book) {
        customer_pnr = customer_pnr;
        customer_pin = customer_pin;
        ISBN_book = ISBN_book;
        return new Customer(customer_pnr, customer_pin, ISBN_book);
    }


    /*
    public int getID_customer() {
        return ID_customer;
    }

    public void setID_customer(int ID_customer) {
        this.ID_customer = ID_customer;
    }

     */

    public String getCustomer_pnr() {
        return customer_pnr;
    }

    public void setCustomer_pnr(String customer_pnr) {
        this.customer_pnr = customer_pnr;
    }

    public String getCustomer_pin() {
        return customer_pin;
    }

    public void setCustomer_pin(String customer_pin) {
        this.customer_pin = customer_pin;
    }

    public String getISBN_book() {
        return ISBN_book;
    }

    public void setISBN_book(String ISBN_book) {
        this.ISBN_book = ISBN_book;
    }

    @Override
    public String toString() {
        return "Customer{" +
                //"ID_customer=" + ID_customer +
                "customer_pnr='" + customer_pnr + '\'' +
                ", customer_pin='" + customer_pin + '\'' +
                '}';
    }
}
