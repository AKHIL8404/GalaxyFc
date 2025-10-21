package com.base.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.base.sms.entity.Player;
import com.base.sms.repository.PlayerRepository;

@SpringBootApplication
public class PlayerApplication implements CommandLineRunner {  // <-- IMPORTANT

	@Autowired
	private PlayerRepository playerRepository;

	public static void main(String[] args) {
		SpringApplication.run(PlayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Player p = new Player(101, "Kroos", "kroos@gmail.com", 32, "Mid Fielder","India");
//		Player p1 = new Player(102, "Roos", "roos@gmail.com", 31, "Mid Fielder","New ZeLand");
//		Player p2 = new Player(103, "Groos", "groos@gmail.com", 30, "Mid Fielder","Germany");
//
//		playerRepository.save(p);
//		playerRepository.save(p1);
//		playerRepository.save(p2);

		System.out.println("✅ Players inserted successfully!");
	}
}
