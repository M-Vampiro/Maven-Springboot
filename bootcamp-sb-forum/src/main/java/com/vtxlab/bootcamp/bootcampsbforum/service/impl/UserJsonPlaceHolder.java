package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbforum.infra.BcUtil;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ResourceNotFound;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.repository.UserRepository;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class UserJsonPlaceHolder implements UserService {

  @Value(value = "${api.jph.domain}")
  private String domain;

  @Value(value = "${api.jph.endpoints.user}")
  private String userEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @PersistenceContext // similar to autowired
  private EntityManager entityManager;

  @Override
  public List<User> getUsers() {
    // RestTemplate restTemplate = new RestTemplate();
    String userUrl = BcUtil.url(Scheme.HTTPS, domain, userEndpoint);
    User[] users = restTemplate.getForObject(userUrl, User[].class);

    return Arrays.stream(users) //
        .collect(Collectors.toList());
  }

  @Override
  public User getUser(int index) {
    Optional<User> userPostDTO = this.getUsers().stream() //
        .filter(e -> e.getId() == index) //
        .findFirst();
    if (userPostDTO.isPresent())
      return userPostDTO.get();
    throw new ResourceNotFound(Syscode.NOTFOUND);
  }

  @Override
  public List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> getAllByEmailOrPhone(
      String email, String phone, Sort sort) {
    return userRepository.findAllByEmailOrPhone(email, phone, sort);
  }

  public List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> getAllByEmailOrPhone(
      String email, String phone) {
    Sort sort = Sort.by("email").ascending().and(Sort.by("phone").ascending());
    return userRepository.findAllByEmailOrPhone(email, phone, sort);
  }

  @Override
  public List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> getUsersByAddrLatGreaterThan(
      Double latitude) {
    return userRepository.findAllByAddrLatGreaterThan(latitude);
  }

  @Override
  public Long countUserByName(String prefix) {
    return userRepository.countUserByNameStartWith(prefix);
  }

  @Override
  @Transactional // all or nothing
  public void updateUserEmailById(Long id, String email) {
    userRepository.updateUser(id, email);
  }

  @Override
  @Transactional
  public com.vtxlab.bootcamp.bootcampsbforum.entity.User updateUserById(
      Long userId, com.vtxlab.bootcamp.bootcampsbforum.entity.User newUser) {
    // entityManager.find() -> select
    com.vtxlab.bootcamp.bootcampsbforum.entity.User oldUser = entityManager
        .find(com.vtxlab.bootcamp.bootcampsbforum.entity.User.class, userId);
    oldUser.setId(newUser.getId());
    oldUser.setName(newUser.getName());
    oldUser.setAddrLat(newUser.getAddrLat());
    oldUser.setAddrLong(newUser.getAddrLong());
    oldUser.setCBusService(newUser.getCBusService());
    oldUser.setCCatchPhrase(newUser.getCCatchPhrase());
    oldUser.setCName(newUser.getCName());
    oldUser.setCity(newUser.getCity());
    oldUser.setEmail(newUser.getEmail());
    oldUser.setPhone(newUser.getPhone());
    oldUser.setSuite(newUser.getSuite());
    oldUser.setZipcode(newUser.getZipcode());
    oldUser.setWebsite(newUser.getWebsite());
    oldUser.setUsername(newUser.getUsername());
    oldUser.setStreet(newUser.getStreet());

    // entityManager.merge() -> update
    entityManager.merge(oldUser);
    return oldUser;
  }

}
