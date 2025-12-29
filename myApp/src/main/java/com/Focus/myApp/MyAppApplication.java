package com.Focus.myApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {

		ApplicationContext context =SpringApplication.run(MyAppApplication.class, args);
		// Here run creates Ioc and returns the obj and also it extends to ApplicationContext

		Alliens obj = context.getBean(Alliens.class); //mention which class obj do you want
		obj.build();
	}

}
