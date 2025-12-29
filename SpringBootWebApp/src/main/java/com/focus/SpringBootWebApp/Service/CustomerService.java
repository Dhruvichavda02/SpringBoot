package com.focus.SpringBootWebApp.Service;


import com.focus.SpringBootWebApp.Model.Customer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {
    List<Customer> cust = Arrays.asList(
            new Customer(101,"Alice","California"),
            new Customer(101,"Bob","California"),
            new Customer(101,"Charlie","California")
            );
    // This list can store only Customer objects


    public List<Customer> getCustomers(){
        return cust;
    }
}

