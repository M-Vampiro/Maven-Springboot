package com.vtxlab.bootcamp.bootcampsbforum.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;

@Repository // Bean
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  // Query "Methods"
  // select * from users where username = ?
  UserEntity findByUsername(String username);

  List<UserEntity> findAllByEmailAndPhoneOrderByEmailDesc(String email,
      String phone);

  List<UserEntity> findAllByEmailOrPhone(String email, String phone, Sort sort);

  // JPQL
  @Query("SELECT e FROM UserEntity e WHERE CAST(e.addrLat AS double) > :lat")
  List<UserEntity> findAllByAddrLatGreaterThan(@Param("lat") Double latitude);

  // Native Query - problem?
  @Query(
      value = "SELECT count(1) FROM USERS u WHERE lower(u.name) LIKE lower(concat(:prefix,'%')) ",
      nativeQuery = true)
  Long countUserByNameStartWith(@Param("prefix") String prefix);

  // Hibernate (implementation class) -> Bean -> Spring Context
  // Objective: Implement JPA interface

  // JPQL
  @Modifying
  @Query("UPDATE UserEntity u SET u.email = :newEmail WHERE u.id = :userId")
  void updateUser(@Param("userId") Long id, @Param("newEmail") String email);

}
