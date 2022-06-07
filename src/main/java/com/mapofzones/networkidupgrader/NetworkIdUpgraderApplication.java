package com.mapofzones.networkidupgrader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetworkIdUpgraderApplication implements CommandLineRunner {
	@Autowired UpgradeService service;

	public static void main(String[] args) {
		SpringApplication.run(NetworkIdUpgraderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.doScript(args);
	}
}
