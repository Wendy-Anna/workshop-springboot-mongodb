package com.wendyanna.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.wendyanna.workshopmongo.domain.Post;
import com.wendyanna.workshopmongo.domain.User;
import com.wendyanna.workshopmongo.dto.AuthorDTO;
import com.wendyanna.workshopmongo.repository.PostRepository;
import com.wendyanna.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;
	
	@Autowired
	private PostRepository postReposiroty;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposiroty.deleteAll();
		postReposiroty.deleteAll();

		
		User wendy = new User(null, "Wendy Lopes", "wendyufpb@gmail.com");
		User sergio = new User(null, "Sérgio Alves", "sergio@gmail.com");
		User paulo = new User(null, "Paulo Emílio", "paulo@gmail.com");
		
		userReposiroty.saveAll(Arrays.asList(wendy, sergio, paulo));

		Post post1 = new Post(null, sdf.parse("23/02/2020"), "Partiu viagem", "Vou viajar para São Paulo. Oyasumi Minna!", new AuthorDTO(wendy));
		Post post2 = new Post(null, sdf.parse("26/02/2020"), "Ohayo", "Acordei feliz hoje!", new AuthorDTO(wendy));

		postReposiroty.saveAll(Arrays.asList(post1, post2));

		wendy.getPosts().addAll(Arrays.asList(post1, post2));
		userReposiroty.save(wendy);
	}

}
