package com.example.demo;

import com.example.demo.entity.Role;
import com.example.demo.entity.Userr;
import com.example.demo.iservices.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MySqlTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySqlTestApplication.class, args);
	}

	@Bean
	CommandLineRunner run(IUserService userService){
		return args -> {
//			userService.saveRole(new Role(null, "ROLE_ADMIN"));
//			userService.saveUser(new Userr(null, "thien", "180897", new ArrayList<>()));
//			userService.addRoleToUser("admin", "ROLE_ADMIN");
//			userService.addRoleToUser("thien", "ROLE_ADMIN");
//			System.out.println(userService.getUsers().toString());
		};
	}
}
