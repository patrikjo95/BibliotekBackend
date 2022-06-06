package com.example.bibliotekbackend.Customer;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.example.bibliotekbackend.Customer.Customer.createCustomer;

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


    @GetMapping("/login_customer")
    public String login_customer(@RequestParam(value = "test_pnr") String customer_pnr,
                                 @RequestParam(value = "test_pin") String customer_pin) {

        Customer customer = new Customer(customer_pnr, customer_pin);

        System.out.println("Controller " + customer);

        Map outParameters = customerService.login_customer(customer);

        Gson gson = new Gson();

        return gson.toJson(outParameters);

    }

    @GetMapping("/borrow_book")
    public String borrow_book(@RequestParam(value = "customer_pnr_live") String customer_pnr,
                              @RequestParam(value = "ISBN_book_live") String ISBN_book) {

        Customer customer = createCustomer(customer_pnr, null, ISBN_book);

        System.out.println("Controller " + customer);

        Map outParameters = customerService.borrow_book(customer);

        Gson gson = new Gson();

        return gson.toJson(outParameters);
    }

    @GetMapping("/which_books_are_borrowed")
    public String which_books_are_borrowed(@RequestParam(value = "customer_pnr_live") String customer_pnr_live) {

        Customer customer = new Customer(customer_pnr_live, null, null);

        System.out.println("Controller " + customer);

        Map outParameters = customerService.which_books_are_borrowed(customer);

        Gson gson = new Gson();

        return gson.toJson(outParameters);
    }

}
