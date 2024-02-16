package com.vtxlab.bootcamp.bootcampsbforum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BootcampSbForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampSbForumApplication.class, args);
	}

}
