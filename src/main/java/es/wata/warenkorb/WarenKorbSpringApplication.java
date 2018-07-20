package es.wata.warenkorb;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WarenKorbSpringApplication {
	private static final Logger LOG = LoggerFactory.getLogger(WarenKorbSpringApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(WarenKorbSpringApplication.class, args);
		LOG.info(LocalDateTime.now().toString()+" Starten des Servers");
	}
}
