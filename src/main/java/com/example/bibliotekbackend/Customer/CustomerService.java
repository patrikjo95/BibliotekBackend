package com.example.bibliotekbackend.Customer;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    Customer customer;
    ArrayList<Customer> customers;

    /**
     * Sends information to DAO class for inserting one new customer.
     */

    public Map add_customer(Customer customer) {

        return customerDao.add_customer(customer.getCustomer_pnr(), customer.getCustomer_pin());

        /**
         * Sends information to DAO class for updating one customer.
         */
    }

    public void updateCustomer(int ID_customer, String customer_pnr, String customer_pin) {
        customerDao.updateCustomer(ID_customer, customer_pnr, customer_pin);
    }


    /**
     * Sends information to DAO class for deleting one customer using ID_book
     */

    public void deleteCustomer(int ID_customers) {
        customerDao.deleteCustomer(ID_customers);
    }

    /**
     * @param ID_customer
     * @return gson String regarding info about one customer, based on ID, sends it to DAO class.
     */

    /*
    public String downloadOneCustomer(int ID_customer) {

        Gson gson = new Gson();
        customer = customerDao.downloadOneCustomerByID(ID_customer);
        String customerString = gson.toJson(customer);
        return customerString;
    }

    public String downloadCustomerByUsername(String customer_username) {
        return customerDao.downloadCustomerByUsername(customer_username);
    }
    
     */

    /**
     * @return gson String with information regarding all customers, sends it to DAO class.
     */

    public String downloadAllCustomers() {
        customers = customerDao.downloadAllCustomers();
        Gson gson = new Gson();
        String customerListString = gson.toJson(customers);
        return customerListString;

    }


    /**
     * assigns to 'book' object, the book with highest ID, by using the newlyAddedBook() method, then...
     * returns a gson String with information regarding this most recently added book to the DAO class.
     *
     * @return please see above.
     */


    // public void deleteCustomer(int id_customers) {


    //public void updateCustomer(int id_customers, String customer_username, String customer_password) {

    //public Map login_Customer(String customer_pnr, String customer_pin) {
    public Map login_customer(Customer customer) {
        return customerDao.login_customer(customer.getCustomer_pnr(), customer.getCustomer_pin());
    }

    public Map borrow_book(Customer customer) {
        return customerDao.borrow_book(customer.getCustomer_pnr(), customer.getISBN_book_live());
    }
}

//public Map insertCustomer(Customer customer) {


