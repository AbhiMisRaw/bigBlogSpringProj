package com.abhimisraw.BigBlog;

import com.abhimisraw.BigBlog.domain.User;
import com.abhimisraw.BigBlog.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BigBlogApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	public BigBlogApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(BigBlogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (userRepository.findAll().isEmpty()){
			String encodedPassword = passwordEncoder.encode("password");
			User user = User.builder().email("admin@gmail.com").userName("admin").password(encodedPassword).role("ADMIN").build();
			System.out.println(user);
			userRepository.save(user);
		}
	}
}
