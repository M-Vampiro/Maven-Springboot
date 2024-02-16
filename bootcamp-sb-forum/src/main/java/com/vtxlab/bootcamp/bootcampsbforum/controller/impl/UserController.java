package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.UserOperation;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController implements UserOperation {

  @Autowired
  private UserService userService;

  @Override
  public List<User> getUsers() {
    System.out.println("start controller");
    return userService.getUsers();
  }

  @Override
  public ApiResponse<Long> countUserByName(String prefix) {
    return ApiResponse.<Long>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userService.countUserByName(prefix)) //
        .build();
  }

  @Override
  public ApiResponse<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>> getUsersByLatGtrThan(
      String latitude) {
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> users =
        userService.getUsersByAddrLatGreaterThan(0.0);
    return ApiResponse.<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(users) //
        .build();
  }

  @Override
  public ApiResponse<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>> getUsersByEmailAndPhone(
      String email, String phone) {
    Sort sortByEmailDesc = Sort.by("email").ascending();
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> users =
        userService.getAllByEmailOrPhone(email, phone, sortByEmailDesc);
    return ApiResponse.<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(users) //
        .build();
  }

  @Override
  public ApiResponse<Void> updateUserEmailById(@PathVariable Long id,
      @PathVariable String email) {
    userService.updateUserEmailById(id, email);
    return ApiResponse.<Void>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(null) //
        .build();
  }

  @Override
  public ApiResponse<com.vtxlab.bootcamp.bootcampsbforum.entity.User> updateUser(
      @PathVariable Long userId,
      @RequestBody com.vtxlab.bootcamp.bootcampsbforum.entity.User user) {

    return ApiResponse.<com.vtxlab.bootcamp.bootcampsbforum.entity.User>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userService.updateUserById(userId, user)) //
        .build();

  }

}
