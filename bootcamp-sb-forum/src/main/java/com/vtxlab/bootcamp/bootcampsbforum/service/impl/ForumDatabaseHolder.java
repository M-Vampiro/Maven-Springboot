package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;
import com.vtxlab.bootcamp.bootcampsbforum.repository.UserRepository;
import com.vtxlab.bootcamp.bootcampsbforum.service.ForumDatabaseService;

@Service
public class ForumDatabaseHolder implements ForumDatabaseService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void deleteAllUsers() {
    userRepository.deleteAll();
  }

  @Override
  public List<User> saveUsers(List<User> users) {
    return userRepository.saveAll(users);
  }

  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }

}
