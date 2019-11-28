package com.alex.controller;

import com.alex.dao.CustomerDAO;
import com.alex.entity.Customer;
import com.alex.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel){


//        get the customers from the service
        List<Customer> theCustomers = customerService.getCustomers();

//        add customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

//        create model attribute to bind customerForm add data
        Customer theCustomer = new Customer();
        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }


    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

//        save the customer using our service
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model model){

//        get the customer from our service
        Customer theCustomer = customerService.getCustomer(theId);

//        set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", theCustomer);

//        send over to our form
        return "customer-form";

    }
}
