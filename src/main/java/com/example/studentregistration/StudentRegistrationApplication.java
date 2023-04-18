package com.example.studentregistration;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;


//@SpringBootApplication

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableScheduling
public class StudentRegistrationApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to my app");
		SpringApplication.run(StudentRegistrationApplication.class, args);
	}


}
