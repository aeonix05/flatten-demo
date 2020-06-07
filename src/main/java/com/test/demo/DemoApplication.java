package com.test.demo;

import com.test.demo.repository.TeamHierarchyRepository;
import com.test.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TeamHierarchyRepository teamHierarchyRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
