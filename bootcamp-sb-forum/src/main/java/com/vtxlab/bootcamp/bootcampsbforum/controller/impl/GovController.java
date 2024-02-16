package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.GovOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.GovService;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@RestController // Bean
@RequestMapping(value = "/gov/api/v1")
public class GovController implements GovOperation {

  @Autowired
  // private UserService userService;
  private GovService govService;

  @Autowired
  private PostService postService;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public ApiResponse<List<UserPostDTO>> getUsers() {
    List<UserPostDTO> userPostDtos = govService.getUsers().stream() // call JPH + save DB
        .map(e -> {
          List<PostDTO> postDTOs = postService.getPosts().stream() //
              .filter(p -> p.getUserId() == e.getId()) //
              .map(p -> {
                return PostDTO.builder() //
                    .id(p.getId()) //
                    .title(p.getTitle()) //
                    .body(p.getBody()).build();
              }).collect(Collectors.toList());

          return UserPostDTO.builder() //
              .id(e.getId()) //
              .username(e.getUsername()) //
              .email(e.getEmail()) //
              .phone(e.getPhone()) //
              .postDTOs(postDTOs) //
              .build();
        }).collect(Collectors.toList());

    return ApiResponse.<List<UserPostDTO>>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userPostDtos) //
        .build();
  }

  @Override
  public ApiResponse<UserPostDTO> getUser(int userId) {
    // 1. User Service
    // 2. Post Service
    // 3. relate the user and post
    // 4. set DTO object and return

    User user = govService.getUser(userId); // call JPH + save DB

    List<PostDTO> postDTOs = postService.getPosts().stream() //
        .filter(e -> e.getUserId() == userId) //
        .map(e -> {
          return PostDTO.builder() //
              .id(e.getId()) //
              .title(e.getTitle()) //
              .body(e.getBody()).build();
        }).collect(Collectors.toList());

    UserPostDTO userPostDTO = UserPostDTO.builder() //
        .id(user.getId()) //
        .username(user.getUsername()).email(user.getEmail()) //
        .phone(user.getPhone()) //
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
        .id(3) //
        .email("abc@gmail.com") //
        .phone("+852 12345678") //
        .username("johnlau") //
        .name("John") //
        .build();
    return modelMapper.map(user, UserDTO.class);
  }

}
