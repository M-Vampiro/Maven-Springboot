package com.vtxlab.bootcamp.bootcampsbforum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bootcampsbforum.service.GovService;

// @Autowired(required = false)
// private CommandLineRunner commandlineRunner;
// main code -> if (commandlineRunner != null) commandlineRunner.run();

// @Component
public class AppRunner implements CommandLineRunner {

  @Autowired
  private GovService govService;
  
  @Override
  public void run(String... args) throws Exception {
    System.out.println("helloworld");
    // Call JPH -> get users -> refresh DB (delete & insert)
    // RestClientException -> throw exception
    govService.getUsersFromJPH();

    // int x = 2;
    // if (x < 3) {
    //   throw new RuntimeException();
    // }
    // Main Tasks in AppRunner:
    // 1. Checking on configuration - DB or yml
    // 2. Invoke API to get data (i.e. configuration, raw data)
  }
  
}
