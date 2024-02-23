package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;

public interface ForumDatabaseService {

  List<UserEntity> saveUsers(List<UserEntity> users);

  void deleteAllUsers();

  UserEntity saveUser(UserEntity user);

}
