package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;

public interface GovOperation {

  // 1. no user found
  // 2. user found, but no posts -> empty array of posts
  @GetMapping(value = "/user")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<UserPostDTO> getUser(@RequestParam(value = "id") int userId);

  @GetMapping(value = "/users")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<UserPostDTO>> getUsers();

  // 1. no user found
  // 2. user found, but no comments -> empty array of comments
  @GetMapping(value = "/comments")
  UserCommentDTO getUserComments(@RequestParam int userId);

  @GetMapping(value = "/test/npe")
  String testNPE();

  @GetMapping(value = "/test/modelmapper")
  UserDTO testModelMapper();

  // 404 -> request path issue or resource not found
  // 204 -> id not found. Processed the business logic, record not found
}
