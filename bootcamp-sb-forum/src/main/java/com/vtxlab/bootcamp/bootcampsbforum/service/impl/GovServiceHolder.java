package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbforum.mapper.UserMapper;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.ForumDatabaseService;
import com.vtxlab.bootcamp.bootcampsbforum.service.GovService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@Service
public class GovServiceHolder implements GovService {

  @Autowired
  private UserService userService;

  @Autowired
  private ForumDatabaseService forumDatabaseService;

  @Autowired
  private UserMapper govMapper;

  @Override
  public List<User> getUsersFromJPH() {
    // call JPH
    List<User> users = userService.getUsersFromJPH();
    // clear DB
    forumDatabaseService.deleteAllUsers();
    // save all users
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> userEntities =
        users.stream() //
            .map(e -> govMapper.mapEntity(e))//
            .collect(Collectors.toList());
    forumDatabaseService.saveUsers(userEntities);
    // return
    return users;
  }

  @Override
  public User getUsersFromJPH(int id) {
    User user = userService.getUserFromJPH(id);
    if (user != null) {
      // convert DTO user to Entity user
      forumDatabaseService.saveUser(govMapper.mapEntity(user));
    }
    return user;
  }
}
