package es.wata.warenkorb;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WarenKorbSpringApplication implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(WarenKorbSpringApplication.class);
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {

		SpringApplication.run(WarenKorbSpringApplication.class, args);
		LOG.info(LocalDateTime.now().toString() + " Starten des Servers");

		
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 5; i++) {
			System.out.println(passwordEncoder.encode("1234567"));
		}
		
	}


}
