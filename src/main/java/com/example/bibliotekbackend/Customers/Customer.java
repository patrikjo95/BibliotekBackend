package com.example.bibliotekbackend.Customers;

public class Customer {

    private String customer_pnr;
    private String customer_pin;



    public Customer(String customer_pnr, String customer_pin) {
        this.customer_pnr = customer_pnr;
        this.customer_pin = customer_pin;
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

    @Override
    public String toString() {
        return "Customer{" +
                "customer_pnr='" + customer_pnr + '\'' +
                ", customer_pin='" + customer_pin + '\'' +
                '}';
    }
}
