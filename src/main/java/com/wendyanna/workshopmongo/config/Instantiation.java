package com.wendyanna.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.wendyanna.workshopmongo.domain.User;
import com.wendyanna.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;
	
	@Override
	public void run(String... args) throws Exception {
		
		userReposiroty.deleteAll();
		
		User wendy = new User(null, "Wendy Lopes", "wendyufpb@gmail.com");
		User sergio = new User(null, "Sérgio Alves", "sergio@gmail.com");
		User paulo = new User(null, "Paulo Emílio", "paulo@gmail.com");
		
		userReposiroty.saveAll(Arrays.asList(wendy, sergio, paulo));
	}

}
