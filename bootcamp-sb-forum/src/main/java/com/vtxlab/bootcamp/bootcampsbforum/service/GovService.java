package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface GovService {

  /**
   * 1. Invoke JPH API to retrieve User List
   * 2. Store/ refresh the whole user list in database
   * 3. return to Gov
   * @param id
   * @return
   */
  User getUser(int id);

  List<User> getUsers();
  
}
