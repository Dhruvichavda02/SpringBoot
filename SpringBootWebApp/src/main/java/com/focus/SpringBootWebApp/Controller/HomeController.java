package com.focus.SpringBootWebApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @RequestMapping("/")

    public String greet(){
        return "Welcome Dhruvi !! ";
    }

    @RequestMapping("/about")
    public String about(){
        return "I dont learn I master ";
    }
}
