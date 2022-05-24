package com.example.bibliotekbackend.Customer;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Sends request to insert a new customer to database
     */

    @GetMapping("/add_customer")
    public String add_customer(@RequestParam(value = "pnr") String customer_pnr,
                               @RequestParam(value = "pin") String customer_pin) {
        Customer customer = new Customer(customer_pnr, customer_pin);

        Map outParameters = customerService.add_customer(customer);

        Gson gson = new Gson();

        return gson.toJson(outParameters);


    }

    /**
     * Sends request to update a new customer in the database, specify ID
     */

    @PostMapping("/updateCustomer")
    public void updateCustomer(@RequestParam(value = "ID_customer", defaultValue = "0") int ID_customer,
                               @RequestParam(value = "customer_pnr") String customer_pnr,
                               @RequestParam(value = "customer_pin") String customer_pin
    ) {
        customerService.updateCustomer(ID_customer, customer_pnr, customer_pin);
    }


    /**
     * Sends request to delete a customer from database by ID
     */
    @DeleteMapping("/deleteCustomerByID")
    public void deleteCustomer(@RequestParam(value = "ID_customer", defaultValue = "-1") int ID_customer) {
        customerService.deleteCustomer(ID_customer);
    }


    /**
     * Sends request to download one customer from database by ID
     */
    /*
    @GetMapping("/downloadOneCustomer")
    public String downloadOneCustomer(@RequestParam(value = "ID_customer", defaultValue = "-1")int ID_customer){
return customerService.downloadOneCustomer(ID_customer);

    }
    */


    /**
     * Sends request to download all customers from database by ID
     */
    @GetMapping("/downloadAllCustomers")
    public String downloadAllCustomers() {
        return customerService.downloadAllCustomers();
    }

    /*
    @GetMapping("/downloadCustomerByUsername")
    public String downloadCustomerByUsername(@RequestParam(value = "customer_pnr", defaultValue = "noCustomer_pnr")String customer_pnr) {
        return customerService.downloadCustomerByUsername(customer_pnr);
    }

     */

    @GetMapping("/login_customer")
    public String login_customer(@RequestParam(value = "test_pnr") String customer_pnr,
                                 @RequestParam(value = "test_pin") String customer_pin) {

        Customer customer = new Customer(customer_pnr, customer_pin);

        System.out.println("Controller " + customer);

        Map outParameters = customerService.login_customer(customer);

        Gson gson = new Gson();

        return gson.toJson(outParameters);


        // return customerService.login_Customer(customer_pnr, customer_pin);
    }

    @GetMapping("/borrow_book")
    public String borrow_book(@RequestParam(value = "customer_pnr_live") String customer_prn,
                              @RequestParam(value = "ISBN_book_live") String ISBN_book_live) {
        Customer customer = new Customer(customer_prn, ISBN_book_live);

        System.out.println("Controller " + customer);

        Map outParameters = customerService.borrow_book(customer);

        Gson gson = new Gson();

        return gson.toJson(outParameters);
    }

}
