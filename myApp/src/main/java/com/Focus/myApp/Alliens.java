package com.Focus.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component

public class Alliens {
    //Field Dependency Injection
//    @Autowired
//    private Laptop laptop;

    // Constructor Injection
//    public Alliens(Laptop laptop){
//        this.laptop = laptop;
//    }

//    // Setter Injection
//    @Autowired
//    public void setLaptop(Laptop laptop){
//        this.laptop = laptop;
//    }


    @Autowired
    private Computer comp;
    public void build() {
        comp.compile();
        System.out.println("Working my ass of!!");
    }
}
