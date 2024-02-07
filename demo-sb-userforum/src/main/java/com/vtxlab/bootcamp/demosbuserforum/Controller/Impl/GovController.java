package com.vtxlab.bootcamp.demosbuserforum.Controller.Impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.demosbuserforum.Controller.GovOperation;
import com.vtxlab.bootcamp.demosbuserforum.DTO.PostDTO;
import com.vtxlab.bootcamp.demosbuserforum.DTO.UserCommentDTO;
import com.vtxlab.bootcamp.demosbuserforum.DTO.UserDTO;
import com.vtxlab.bootcamp.demosbuserforum.DTO.UserPostDTO;
import com.vtxlab.bootcamp.demosbuserforum.DTO.GovMapper.GovMapper;
import com.vtxlab.bootcamp.demosbuserforum.Infra.ApiResponse;
import com.vtxlab.bootcamp.demosbuserforum.Infra.Syscode;
import com.vtxlab.bootcamp.demosbuserforum.Model.DTO.JPH.User;
import com.vtxlab.bootcamp.demosbuserforum.Service.PostService;
import com.vtxlab.bootcamp.demosbuserforum.Service.UserService;

@RestController
@RequestMapping(value = "/gov/api/v1")
public class GovController implements GovOperation {

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  GovMapper govMapper;

  @Override
  public ApiResponse<UserPostDTO> getUser(int userId) {
    // 1. User Service
    // 2. Post Service
    // 3. relate the user and post
    // 4. set DTO object and return

    User user = userService.getUser(userId);

    List<PostDTO> postDTOs = postService.getPosts().stream() //
        .filter(e -> e.getUserId() == userId) //
        .map(e -> {
          return PostDTO.builder() //
              .id(e.getId()) //
              .title(e.getTitle()) //
              .body(e.getBody()).build();
        }).collect(Collectors.toList());

    UserPostDTO userPostDTO = UserPostDTO.builder() //
        .id(user.getId()).email(user.getEmail()).phone(user.getPhone())
        .postDTOs(postDTOs).build();

    return ApiResponse.<UserPostDTO>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userPostDTO) //
        .build();
  }

  @Override
  public UserCommentDTO getUserComments(int userId) {
    return null;
  }

  // GlobalExceptionHandler -> NPE
  @Override
  public String testNPE() {
    String s = null;
    return s.concat("hello");
  }

  @Override
  public UserDTO testModelMapper() {
    User user = User.builder() //
        .id(3)
        .email("abs@gmail.com")
        .phone("+852 12345678")
        .username("johnlau")
        .name("John")
        .build();

    return govMapper.map(user);
  }

}