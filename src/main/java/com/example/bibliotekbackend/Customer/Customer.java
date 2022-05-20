package com.example.bibliotekbackend.Customer;

public class Customer {
    // private int ID_customer;
    private String customer_pnr;
    private String customer_pin;


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

    @Override
    public String toString() {
        return "Customer{" +
                //"ID_customer=" + ID_customer +
                "customer_pnr='" + customer_pnr + '\'' +
                ", customer_pin='" + customer_pin + '\'' +
                '}';
    }
}
