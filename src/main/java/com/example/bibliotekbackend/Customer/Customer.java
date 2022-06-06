package com.example.bibliotekbackend.Customer;

public class Customer {
    private String customer_pnr;
    private String customer_pin;
    private String ISBN_book;


    public Customer(String customer_pnr, String customer_pin) {
        this.customer_pnr = customer_pnr;
        this.customer_pin = customer_pin;
    }

    public Customer(String customer_pnr, String customer_pin, String ISBN_book) {
        this.customer_pnr = customer_pnr;
        this.customer_pin = customer_pin;
        this.ISBN_book = ISBN_book;
    }


    public static Customer createCustomer(String customer_pnr, String customer_pin, String ISBN_book) {
        customer_pnr = customer_pnr;
        customer_pin = customer_pin;
        ISBN_book = ISBN_book;
        return new Customer(customer_pnr, customer_pin, ISBN_book);
    }


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
                "customer_pnr='" + customer_pnr + '\'' +
                ", customer_pin='" + customer_pin + '\'' +
                ", ISBN_book='" + ISBN_book + '\'' +
                '}';
    }
}
