package com.example.studentregistration;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


//@SpringBootApplication

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class StudentRegistrationApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to my app");
		SpringApplication.run(StudentRegistrationApplication.class, args);
	}


}
