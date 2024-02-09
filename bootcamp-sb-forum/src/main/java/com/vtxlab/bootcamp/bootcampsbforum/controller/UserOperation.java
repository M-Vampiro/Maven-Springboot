package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserOperation {

  @GetMapping(value = "/users")
  List<User> getUsers();

}
