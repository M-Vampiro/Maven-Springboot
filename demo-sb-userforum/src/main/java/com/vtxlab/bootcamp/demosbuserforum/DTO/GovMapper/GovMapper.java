package com.vtxlab.bootcamp.demosbuserforum.DTO.GovMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vtxlab.bootcamp.demosbuserforum.DTO.PostDTO;
import com.vtxlab.bootcamp.demosbuserforum.DTO.UserDTO;
import com.vtxlab.bootcamp.demosbuserforum.DTO.UserPostDTO;
import com.vtxlab.bootcamp.demosbuserforum.Model.DTO.JPH.Post;
import com.vtxlab.bootcamp.demosbuserforum.Model.DTO.JPH.User;

// when server starts, Spring ensures modelMapper object is ready before creating GovMapper object;

@Component
public class GovMapper {

  @Autowired
  private ModelMapper modelMapper;

  public UserDTO map(User user) {
    return this.modelMapper.map(user, UserDTO.class);
  }

  public UserPostDTO map(User user, List<Post> posts) {

    List<PostDTO> postDTOs = posts.stream() //
        .filter(e -> e.getUserId() == user.getId()) //
        .map(e -> {
          return PostDTO.builder() //
              .id(e.getId()) //
              .title(e.getTitle()) //
              .body(e.getBody())//
              .build();
        }).collect(Collectors.toList());

    // return UserPostDTO.builder() //
    // .id(user.getId()).username(user.getUsername()) //
    // .email(user.getEmail()) //
    // .phone(user.getPhone()) //
    // .postDTOs(postDTOs) //
    // .build();
    // ModelMapper mm = new ModelMapper();

    // map all fields by name;
    UserPostDTO userPostDTO = this.modelMapper.map(user, UserPostDTO.class);
    userPostDTO.setPostDTOs(postDTOs);
    return userPostDTO;
    //
  }
}