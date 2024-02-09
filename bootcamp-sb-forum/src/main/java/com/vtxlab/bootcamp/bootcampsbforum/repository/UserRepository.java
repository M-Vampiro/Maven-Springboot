package com.vtxlab.bootcamp.bootcampsbforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;

@Repository // Bean
public interface UserRepository extends JpaRepository<User, Long> {
  
  // Hibernate (implementation class) -> Bean -> Spring Context
  // Objective: Implement JPA interface

}
