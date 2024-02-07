package com.vtxlab.bootcamp.demosbuserforum.Service;

import java.util.List;

import com.vtxlab.bootcamp.demosbuserforum.Model.DTO.JPH.User;

public interface UserService {

  List<User> getUsers();

  User getUser(int index);

}