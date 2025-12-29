package com.Focus.myApp;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {


        public void compile(){

            System.out.println("Hello from Desktop");
    }
}
