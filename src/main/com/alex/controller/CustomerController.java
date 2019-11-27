package com.alex.controller;

import com.alex.dao.CustomerDAO;
import com.alex.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


//    inject the customer DAO
    @Autowired
    private CustomerDAO customerDAO;


    @RequestMapping("/list")
    public String listCustomers(Model theModel){

//        get the customers from the DAO
        List<Customer> theCustomers = customerDAO.getCustomers();

//        add customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }


}
