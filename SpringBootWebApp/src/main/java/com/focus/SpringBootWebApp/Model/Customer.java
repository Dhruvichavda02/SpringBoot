package com.focus.SpringBootWebApp.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data   //getter,setter,equal,toString()
@AllArgsConstructor
public class Customer {
    private int customerId;
    private String customerName;
    private String city;

}
