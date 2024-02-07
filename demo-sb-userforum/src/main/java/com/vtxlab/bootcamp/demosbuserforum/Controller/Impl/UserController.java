package com.vtxlab.bootcamp.demosbuserforum.Controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.demosbuserforum.Controller.UserOperation;
import com.vtxlab.bootcamp.demosbuserforum.Model.DTO.JPH.User;
import com.vtxlab.bootcamp.demosbuserforum.Service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController implements UserOperation {

  @Autowired
  private UserService userService;

  @Override
  public String hello() {
    return "h";
  }

  @Override
  public List<User> getUsers() {
    System.out.println("start controller");
    return userService.getUsers();
  }

}
