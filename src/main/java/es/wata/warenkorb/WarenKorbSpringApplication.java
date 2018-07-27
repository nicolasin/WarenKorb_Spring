package es.wata.warenkorb;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import es.wata.warenkorb.helperClasses.CustomerKundeDetails;
import es.wata.warenkorb.repository.KundeRepository;

@SpringBootApplication
public class WarenKorbSpringApplication {
	private static final Logger LOG = LoggerFactory.getLogger(WarenKorbSpringApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(WarenKorbSpringApplication.class, args);
		LOG.info(LocalDateTime.now().toString() + " Starten des Servers");
	}

	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, KundeRepository repo) throws Exception {
		builder.userDetailsService(s -> new CustomerKundeDetails(repo.findByName(s)));

	}

}
