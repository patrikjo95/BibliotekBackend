package com.example.bibliotekbackend.Customers;


import com.example.bibliotekbackend.Books.Book;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Data access object for customer table in database
 */
@Repository
public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String error;

    public CustomerDao() {
        this.error ="no";
        this.jdbcTemplate = new JdbcTemplate();

    }
    /**
     * method to insert a new customer into the database
     */
    public Map instertCustomer(String customer_pnr, String customers_password){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add customer");

    Map<String, String> inParameters = new HashMap<>();

    Customer customer = new Customer(customer_pnr, customers_password);

    inParameters.put("new_customer_pnr", customer_pnr);
    inParameters.put("new_customers_password",customers_password);

    SqlParameterSource in = new MapSqlParameterSource(inParameters);

    Map<String, Object> outParameters = jdbcCall.execute(in);

    customer.setCustomer_pnr(customer_pnr);
    customer.setCustomers_password(customers_password);

    return outParameters;
}

    /**
     * updates a customer in database by ID
     */

    public void updateCustomer(int ID_customers, String customer_pnr, String customers_password) {
        String query = "UPDATE customers SET customer_pnr = ?, customers_password = ? WHERE ID_customer = ?;";
        int result = jdbcTemplate.update(query,customer_pnr, customers_password, ID_customers);

        if (result > 0) {
            System.out.println(result + "customer updated in database");
            this.error = "customer updated in database";
        }
    }

    /**
     * method to delete a customer from database using ID
     */

    public void deleteCustomer(int ID_customer) {
        String query = "DELETE FROM customers WHERE ID_customer = ?;";
        int result = jdbcTemplate.update(query, ID_customer);

        if (result > 0) {
            System.out.println(result + "customer deleted in database");
            this.error = "customer deleted in database";

        }

    }

    /**
     * gets one customer from the database by id
     */

    public Customer downloadOneCustomerByID( int ID_customer) {

        String query ="SELECT * FROM Customer WHERE ID_customer =?;";

        return this.jdbcTemplate.queryForObject(query, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer innerCUstomer = new Customer(
                        rs.getInt("ID_customer"),
                        rs.getString("customer_pnr"),
                        rs.getString("customers_password")


                );
                return innerCUstomer;
            }
        }, ID_customer);


    }

    /**
     * gets one customer from the database by username
     */

    public String downloadCustomerByUsername(String customer_pnr) {

        Gson gson = new Gson();

        String query = "SELECT * FROM Customer WHERE customer_pnr = ?;";
        Customer temp = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Customer(
                rs.getInt("ID_customer"),
                rs.getString("customer_pnr"),
                rs.getString("customers_password")),customer_pnr);
        return gson.toJson(temp);
    }

    /**
     * downloads all customers from the database
     *
     * @return ArrayList<Customer>
     */

    public ArrayList<Customer> downloadAllCustomers() {
        String query = "SELECT * FROM customers;";
        ArrayList<Customer> customers = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows) {
            Customer customer = new Customer(
                     String.valueOf(row.get("ID_customers")),
                    String.valueOf(row.get("customer_pnr")));
                    customers.add(customer);
        }
        customers.sort(Comparator.comparing(Customer::getCustomer_pnr));
        return customers;
    }

        /**
         * Method to download the customer with the highest id,
         */

        public Customer newlyAddedCustomer() {
            String query = "SELECT * FROM customer WHERE ID_customer = (SELECT MAX(ID_customer)FROM customer);";
            Customer temp = jdbcTemplate.queryForObject(query, (rs,  rowNum) -> {
                Customer customer = new Customer(rs.getString("ID_customers"),
                        rs.getString("customer_pnr"));
                return customer;
            });
            return temp;


        }



    }












