package com.vtxlab.bootcamp.bootcampsbforum.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;

@Repository // Bean
public interface UserRepository extends JpaRepository<User, Long> {

  // Query "Methods"
  // select * from users where username = ?
  User findByUsername(String username);

  List<User> findAllByEmailAndPhoneOrderByEmailDesc(String email, String phone);

  List<User> findAllByEmailOrPhone(String email, String phone, Sort sort);

  // JPQL
  @Query("SELECT e FROM User e WHERE CAST(e.addrLat AS double) > :lat")
  List<User> findAllByAddrLatGreaterThan(@Param("lat") Double latitude);

  // Native Query - problem?
  @Query(
      value = "SELECT count(1) FROM USERS u WHERE lower(u.name) LIKE lower(concat(:prefix,'%')) ",
      nativeQuery = true)
  Long countUserByNameStartWith(@Param("prefix") String prefix);

  // Hibernate (implementation class) -> Bean -> Spring Context
  // Objective: Implement JPA interface

  // JPQL
  @Modifying
  @Query("UPDATE User u SET u.email = :newEmail WHERE u.id = :userId")
  void updateUser(@Param("userId") Long id, @Param("newEmail") String email);

}
