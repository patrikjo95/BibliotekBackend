package com.example.bibliotekbackend.CustomerDetails;

public class CustomerDetails {
    private String customer_firstname;
    private String customer_lastname;
    private String customer_mail;
    private String customer_phonenumber;
    private String customer_adress;
    private String customer_city;
    private String customer_zip_code;
    private String customer_pnr;
    private int customers_ID_customers;

    public CustomerDetails(String customer_firstname, String customer_lastname, String customer_mail, String customer_phonenumber, String customer_adress, String customer_city, String customer_zip_code, String customer_pnr, int customers_ID_customers) {
        this.customer_firstname = customer_firstname;
        this.customer_lastname = customer_lastname;
        this.customer_mail = customer_mail;
        this.customer_phonenumber = customer_phonenumber;
        this.customer_adress = customer_adress;
        this.customer_city = customer_city;
        this.customer_zip_code = customer_zip_code;
        this.customer_pnr = customer_pnr;
        this.customers_ID_customers = customers_ID_customers;
    }

    public String getCustomer_firstname() {
        return customer_firstname;
    }

    public void setCustomer_firstname(String customer_firstname) {
        this.customer_firstname = customer_firstname;
    }

    public String getCustomer_lastname() {
        return customer_lastname;
    }

    public void setCustomer_lastname(String customer_lastname) {
        this.customer_lastname = customer_lastname;
    }

    public String getCustomer_mail() {
        return customer_mail;
    }

    public void setCustomer_mail(String customer_mail) {
        this.customer_mail = customer_mail;
    }

    public String getCustomer_phonenumber() {
        return customer_phonenumber;
    }

    public void setCustomer_phonenumber(String customer_phonenumber) {
        this.customer_phonenumber = customer_phonenumber;
    }

    public String getCustomer_adress() {
        return customer_adress;
    }

    public void setCustomer_adress(String customer_adress) {
        this.customer_adress = customer_adress;
    }

    public String getCustomer_city() {
        return customer_city;
    }

    public void setCustomer_city(String customer_city) {
        this.customer_city = customer_city;
    }

    public String getCustomer_zip_code() {
        return customer_zip_code;
    }

    public void setCustomer_zip_code(String customer_zip_code) {
        this.customer_zip_code = customer_zip_code;
    }

    public String getCustomer_pnr() {
        return customer_pnr;
    }

    public void setCustomer_pnr(String customer_pnr) {
        this.customer_pnr = customer_pnr;
    }

    public int getCustomers_ID_customers() {
        return customers_ID_customers;
    }

    public void setCustomers_ID_customers(int customers_ID_customers) {
        this.customers_ID_customers = customers_ID_customers;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "customer_firstname='" + customer_firstname + '\'' +
                ", customer_lastname='" + customer_lastname + '\'' +
                ", customer_mail='" + customer_mail + '\'' +
                ", customer_phonenumber='" + customer_phonenumber + '\'' +
                ", customer_adress='" + customer_adress + '\'' +
                ", customer_city='" + customer_city + '\'' +
                ", customer_zip_code='" + customer_zip_code + '\'' +
                ", customer_pnr='" + customer_pnr + '\'' +
                ", customers_ID_customers=" + customers_ID_customers +
                '}';
    }
}
