package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.UserOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController implements UserOperation {

  @Autowired
  private UserService userService;

  @Override
  public List<User> getUsers() {
    return userService.getUsersFromJPH();
  }

  @Override
  public ApiResponse<Long> countUserByName(String prefix) {
    return ApiResponse.<Long>builder() //
        .ok() //
        .data(userService.countUserByName(prefix)) //
        .build();
  }

  @Override
  public ApiResponse<List<UserEntity>> getUsersByLatGtrThan(String latitude) {
    List<UserEntity> users = userService.getUsersByAddrLatGreaterThan(0.0);
    return ApiResponse.<List<UserEntity>>builder() //
        .ok() //
        .data(users) //
        .build();
  }

  @Override
  public ApiResponse<List<UserEntity>> getUsersByEmailAndPhone(String email,
      String phone) {
    Sort sortByEmailDesc = Sort.by("email").ascending();
    List<UserEntity> users =
        userService.getAllByEmailOrPhone(email, phone, sortByEmailDesc);
    return ApiResponse.<List<UserEntity>>builder() //
        .ok()//
        .data(users) //
        .build();
  }

  @Override
  public ApiResponse<Void> updateUserEmailById(@PathVariable Long id,
      @PathVariable String email) {
    userService.updateUserEmailById(id, email);
    return ApiResponse.<Void>builder() //
        .ok()//
        .data(null) //
        .build();
  }

  @Override
  public ApiResponse<UserEntity> updateUser(@PathVariable Long userId,
      @RequestBody UserEntity user) {

    return ApiResponse.<UserEntity>builder() //
        .ok()//
        .data(userService.updateUserById(userId, user)) //
        .build();
  }

  @PostMapping(value = "/user")
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponse<UserEntity> save(UserPostRequestDTO userRequestDTO) {
    return ApiResponse.<UserEntity>builder() //
        .ok() //
        .data(userService.save(userRequestDTO)) //
        .build();
  }

}
