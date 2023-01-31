package com.example.spring.boot.docker.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages={"com.example"})
@RestController
@CrossOrigin
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example"})
@EntityScan("com.example")
@EnableJpaRepositories("com.example")

public class SpringBootDockerApplication {
	@Autowired
    private UsersServiceImpl usersServiceImpl;
	
	@GetMapping("/message/{fname}")
	@CrossOrigin
	public String getMessage(@PathVariable String fname) {		
				
		System.err.println("f name : " + usersServiceImpl.getLname(fname));
		return "{ \"message\":\"Hello "+ fname + " " + usersServiceImpl.getLname(fname) +"\"}";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerApplication.class, args);
	}

}
