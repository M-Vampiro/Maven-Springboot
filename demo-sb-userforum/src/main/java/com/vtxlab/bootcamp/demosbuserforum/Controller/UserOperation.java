package com.vtxlab.bootcamp.demosbuserforum.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.vtxlab.bootcamp.demosbuserforum.Model.DTO.JPH.User;


  public interface UserOperation {

  @GetMapping(value = "/hello")
  String hello();

  @GetMapping(value = "/users")
  List<User> getUsers();

  
}
