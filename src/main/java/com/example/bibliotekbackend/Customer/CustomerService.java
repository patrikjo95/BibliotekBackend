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

    }

    public Map login_customer(Customer customer) {
        return customerDao.login_customer(customer.getCustomer_pnr(), customer.getCustomer_pin());
    }

    public Map borrow_book(Customer customer) {
        return customerDao.borrow_book(customer.getCustomer_pnr(), customer.getISBN_book());
    }

    public Map which_books_are_borrowed(Customer customer) {
        return customerDao.which_books_are_borrowed(customer.getCustomer_pnr());
    }
}


