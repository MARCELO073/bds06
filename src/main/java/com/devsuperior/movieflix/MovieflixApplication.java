package com.devsuperior.movieflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieflixApplication {

/*@Autowired
	private  UserRepository userRepository;
	*/
	public static void main(String[] args) {
		SpringApplication.run(MovieflixApplication.class, args);
	}
	
	
	/*@Override
	public void run(String...args)throws Exception{
	
		List<User> list = userRepository.findByEmail("RS");
	}	*/	


}
