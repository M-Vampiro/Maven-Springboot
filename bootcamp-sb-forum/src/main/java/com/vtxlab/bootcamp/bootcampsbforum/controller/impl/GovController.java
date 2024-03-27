package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.GovOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.request.UserIdRQDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.response.gov.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.response.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.GovService;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;

// @Autowired
// private GovOperation govOperation; // inject GovController object

@RestController // Bean
@RequestMapping(value = "/gov/api/v1")
public class GovController implements GovOperation {

  @Autowired
  private GovService govService;

  @Autowired
  private PostService postService;

  @Override
  public ApiResponse<List<UserPostDTO>> getUsersFromJPH() {
    List<UserPostDTO> userPostDtos = govService.getUsersFromJPH().stream() // call JPH + save DB
        .map(e -> {
          List<PostDTO> postDTOs = postService.getPostsFromJPH().stream() //
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
        .ok().data(userPostDtos) //
        .build();
  }

  @Override
  public ApiResponse<UserPostDTO> getUsersFromJPH(UserIdRQDTO userdto) {
    // 1. User Service
    // 2. Post Service
    // 3. relate the user and post
    // 4. set DTO object and return

    User user = govService.getUsersFromJPH(Integer.valueOf(userdto.getId())); // call JPH + save DB

    List<PostDTO> postDTOs = postService.getPostsFromJPH().stream() //
        .filter(e -> e.getUserId() == user.getId()) //
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
        .ok().data(userPostDTO) //
        .build();
  }

}
