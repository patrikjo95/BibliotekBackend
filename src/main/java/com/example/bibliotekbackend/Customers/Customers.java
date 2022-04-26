package com.example.bibliotekbackend.Customers;

public class Customers {
    private int ID_customers;
    private String customer_username;
    private String customers_password;


    public Customers(int ID_customer, String customer_username, String customer_password) {
        this.ID_customers = ID_customer;
        this.customer_username = customer_username;
        this.customers_password = customer_password;
    }

    public int getID_customers() {
        return ID_customers;
    }

    public void setID_customers(int ID_customers) {
        this.ID_customers = ID_customers;
    }

    public String getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(String customer_username) {
        this.customer_username = customer_username;
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
                ", customer_username='" + customer_username + '\'' +
                ", customers_password='" + customers_password + '\'' +
                '}';
    }
}
