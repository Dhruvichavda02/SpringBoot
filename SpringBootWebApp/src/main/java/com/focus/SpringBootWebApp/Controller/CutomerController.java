package com.focus.SpringBootWebApp.Controller;

import com.focus.SpringBootWebApp.Model.Customer;
import com.focus.SpringBootWebApp.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CutomerController
{
    @Autowired
    CustomerService service;

    @RequestMapping("/cust")
    public List<Customer> getCustomer(){
        return service.getCustomers();
    }

}
