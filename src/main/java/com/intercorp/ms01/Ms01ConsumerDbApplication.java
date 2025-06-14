package com.intercorp.ms01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class Ms01ConsumerDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms01ConsumerDbApplication.class, args);
	}

}
