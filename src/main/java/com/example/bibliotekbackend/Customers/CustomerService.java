package com.example.bibliotekbackend.Customers;


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

    public Map insertCustomer(Customer customer) {

        return customerDao.instertCustomer(customer.getCustomer_pnr(), customer.getCustomers_password());

        /**
         * Sends information to DAO class for updating one customer.
         */
    }
        public void updateCustomer(int ID_customers, String customer_pnr, String customers_password){
            customerDao.updateCustomer(ID_customers, customer_pnr, customers_password);
        }



    /**
     * Sends information to DAO class for deleting one customer using ID_book
     */

    public void deleteCustomer(int ID_customers){
        customerDao.deleteCustomer(ID_customers);
    }

    /**
     * @param ID_customer
     * @return gson String regarding info about one customer, based on ID, sends it to DAO class.
     */

    public String downloadOneCustomer(int ID_customer) {

        Gson gson = new Gson();
        customer = customerDao.downloadOneCustomerByID(ID_customer);
        String customerString = gson.toJson(customer);
        return customerString;
    }

    public String downloadCustomerByUsername(String customer_username) { return customerDao.downloadCustomerByUsername(customer_username);}

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
    }

    //public Map insertCustomer(Customer customer) {


