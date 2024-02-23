package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import com.vtxlab.bootcamp.bootcampsbforum.dto.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserService {

  List<User> getUsersFromJPH();

  User getUserFromJPH(int index);

  List<UserEntity> getAllByEmailOrPhone(String email, String phone, Sort sort);

  List<UserEntity> getUsersByAddrLatGreaterThan(Double latitude);

  Long countUserByName(String prefix);

  void updateUserEmailById(Long id, String email);

  UserEntity updateUserById(Long id, UserEntity user);

  // Save
  public UserEntity save(UserPostRequestDTO userRequestDTO);

}
