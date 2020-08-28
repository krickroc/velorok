package velorok.shop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import velorok.shop.api.models.Bike;
import velorok.shop.api.models.User;
import velorok.shop.api.repositories.BikeRepository;
import velorok.shop.api.repositories.UserRepository;

import java.util.Arrays;

@SpringBootApplication
public class ApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
