package in.cdac.ageservice.ageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AgeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgeServiceApplication.class, args);
	}
}
