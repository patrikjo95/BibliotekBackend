package com.example.bibliotekbackend.Customers;

public class Customer {
    private int ID_customers;
    private String customer_pnr;
    private String customers_password;


    public Customer(int ID_customers, String customer_pnr, String customers_password) {
        this.ID_customers = ID_customers;
        this.customer_pnr = customer_pnr;
        this.customers_password = customers_password;
    }

    public Customer(String customer_pnr, String customers_password) {
        this.customer_pnr = customer_pnr;
        this.customers_password = customers_password;
    }

    public int getID_customers() {
        return ID_customers;
    }

    public void setID_customers(int ID_customers) {
        this.ID_customers = ID_customers;
    }

    public String getCustomer_pnr() {
        return customer_pnr;
    }

    public void setCustomer_pnr(String customer_username) {
        this.customer_pnr = customer_pnr;
    }

    public String getCustomers_password() {
        return customers_password;
    }

    public void setCustomers_password(String customers_password) {
        this.customers_password = customers_password;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "ID_customers=" + ID_customers +
                ", customer_username='" + customer_pnr + '\'' +
                ", customers_password='" + customers_password + '\'' +
                '}';
    }
}
