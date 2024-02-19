package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserService {

  List<User> getUsers();

  User getUser(int index);

  List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> getAllByEmailOrPhone(
      String email, String phone, Sort sort);

  List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> getUsersByAddrLatGreaterThan(
      Double latitude);

  Long countUserByName(String prefix);

  void updateUserEmailById(Long id, String email);

  com.vtxlab.bootcamp.bootcampsbforum.entity.User updateUserById(Long id,
      com.vtxlab.bootcamp.bootcampsbforum.entity.User user);

}
