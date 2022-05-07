package com.example.bibliotekbackend.Customers;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public CustomerController(CustomerService customerService){this.customerService = customerService;}
    /**
     * Sends request to insert a new customer to database
     */

    @GetMapping ("/insertCustomer")
    public String insertCustomer (@RequestParam(value ="new customer_pnr")String customer_pnr,
                                  @RequestParam(value = "new customers_password") String customers_password,
                                  @RequestParam(value = "new ID_customers") int ID_customers
    )
    {
        Customer customer = new Customer(ID_customers,customer_pnr,customers_password);

        Map outParameters = customerService.insertCustomer(customer);

        Gson gson = new Gson();
        return gson.toJson(outParameters);
        //customerService.insertCustomer(customer_pnr, customers_password, ID_customers);


    }
    /**
     * Sends request to update a new customer in the database, specify ID
     */

    @PostMapping("/updateCustomer")
    public void updateCustomer(@RequestParam(value = "ID_customers", defaultValue = "0")int ID_customers,
                               @RequestParam(value = "customer_pnr") String customer_pnr,
                               @RequestParam(value = "customers_password") String customers_password
    ) {
        customerService.updateCustomer(ID_customers, customer_pnr, customers_password);
    }


    /**
     * Sends request to delete a customer from database by ID
     */
    @DeleteMapping("/deleteCustomerByID")
    public void deleteCustomer(@RequestParam(value = "ID_customers", defaultValue = "-1")int ID_customers) {
        customerService.deleteCustomer(ID_customers);
    }

    /**
     * Sends request to download one customer from database by ID
     */
    @GetMapping("/downloadOneCustomer")
    public String downloadOneCustomer(@RequestParam(value = "ID_customers", defaultValue = "-1")int ID_customers){
return customerService.downloadOneCustomer(ID_customers);

    }


    /**
     * Sends request to download all customers from database by ID
     */
    @GetMapping("/downloadAllCustomers")
    public String downloadAllCustomers() {return customerService.downloadAllCustomers();
    }

    @GetMapping("/downloadCustomerByUsername")
    public String downloadCustomerByUsername(@RequestParam(value = "customer_pnr", defaultValue = "noCustomer_pnr")String customer_pnr) {
        return customerService.downloadCustomerByUsername(customer_pnr);
    }


}
