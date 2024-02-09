package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserService {

  List<User> getUsers();

  User getUser(int index);

}
