package hu.elte.alkfejl.DormRooms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;
import java.util.Random;

@SpringBootApplication
public class DormRoomsApplication {
	public static SecureRandom globalSecureRandomGenerator = new SecureRandom();
	public static void main(String[] args) {
		SpringApplication.run(DormRoomsApplication.class, args);
	}

}
