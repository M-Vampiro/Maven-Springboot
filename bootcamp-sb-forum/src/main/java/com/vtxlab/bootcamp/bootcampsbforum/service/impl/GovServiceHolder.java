package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbforum.mapper.GovMapper;
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
  private GovMapper govMapper;

  @Override
  public List<User> getUsers() {
    // call JPH
    List<User> users = userService.getUsers();
    // clear DB
    forumDatabaseService.deleteAllUsers();
    // save all users
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> userEntities =
        users.stream() //
            .map(e -> govMapper.mapEntity(e))//
            .collect(Collectors.toList());
    forumDatabaseService.saveUsers(userEntities);
    // return
    return users;
  }

  @Override
  public User getUser(int id) {
    User user = userService.getUser(id);
    if (user != null) {
      // convert DTO user to Entity user
      forumDatabaseService.saveUser(govMapper.mapEntity(user));
    }
    return user;
  }
}
