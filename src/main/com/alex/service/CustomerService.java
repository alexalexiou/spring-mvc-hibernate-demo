package com.alex.service;

import com.alex.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public  Customer getCustomer(int theId);
}
