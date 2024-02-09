package com.vtxlab.bootcamp.bootcampsbforum.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Library (dependency) or your own classess -> object (bean) -> Spring context
@Configuration
public class AppConfig {

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
