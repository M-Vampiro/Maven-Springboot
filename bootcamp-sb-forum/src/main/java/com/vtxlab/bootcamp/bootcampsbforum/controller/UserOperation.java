package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.dto.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserOperation {

  @GetMapping(value = "/users")
  List<User> getUsers();

  @GetMapping(value = "/users/count")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<Long> countUserByName(
      @RequestParam(value = "prefix") String prefix);

  @GetMapping(value = "/users/lat/{lat}")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<UserEntity>> getUsersByLatGtrThan(
      @PathVariable(value = "lat") String latitude);

  @GetMapping(value = "/users/email/{email}/phone/{phone}")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<UserEntity>> getUsersByEmailAndPhone(
      @PathVariable String email, @PathVariable String phone);

  @GetMapping(value = "/users/{id}/{email}")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<Void> updateUserEmailById(@PathVariable Long id,
      @PathVariable String email);

  @PutMapping(value = "/user/id/{userId}")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<UserEntity> updateUser(@PathVariable Long userId,
      @RequestBody UserEntity user);

  // Save
  @PostMapping(value = "/user")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<UserEntity> save(@RequestBody UserPostRequestDTO userRequestDTO);
}

