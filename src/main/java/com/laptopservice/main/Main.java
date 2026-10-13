package com.laptopservice.main;

import com.laptopservice.dao.CustomerDAO;
import com.laptopservice.entity.Customer;

public class Main {

    public static void main(String[] args) {

        CustomerDAO customerDAO = new CustomerDAO();

        customerDAO.saveCustomer(
            new Customer(
                "Surya",
                "9876500001",
                "surya@gmail.com",
                "Tirunelveli"
            )
        );

        customerDAO.saveCustomer(
            new Customer(
                "Vijay",
                "9876500002",
                "vijay@gmail.com",
                "Madurai"
            )
        );

        customerDAO.saveCustomer(
            new Customer(
                "Maran",
                "9876500003",
                "maran@gmail.com",
                "Tenkasi"
            )
        );

        customerDAO.saveCustomer(
            new Customer(
                "Sathish",
                "9876500004",
                "sathish@gmail.com",
                "Chennai"
            )
        );

        customerDAO.saveCustomer(
            new Customer(
                "Sundar",
                "9876500005",
                "sundar@gmail.com",
                "Coimbatore"
            )
        );

        System.out.println("5 Customers inserted successfully!");
    }
}