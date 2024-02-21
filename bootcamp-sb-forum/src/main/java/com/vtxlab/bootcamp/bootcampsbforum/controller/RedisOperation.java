package com.vtxlab.bootcamp.bootcampsbforum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbforum.model.User2;

public interface RedisOperation {

  @PostMapping(value = "/user2")
  User2 createUser(@RequestParam String key, @RequestBody User2 user)
      throws JsonProcessingException;

  @GetMapping(value = "/user2")
  User2 getUser(@RequestParam String key) throws JsonProcessingException;

}
