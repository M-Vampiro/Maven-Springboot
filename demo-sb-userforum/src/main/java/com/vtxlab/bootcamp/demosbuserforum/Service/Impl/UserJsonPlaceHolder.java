package com.vtxlab.bootcamp.demosbuserforum.Service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vtxlab.bootcamp.demosbuserforum.Infra.BcUtil;
import com.vtxlab.bootcamp.demosbuserforum.Infra.ResourceNotFound;
import com.vtxlab.bootcamp.demosbuserforum.Infra.Scheme;
import com.vtxlab.bootcamp.demosbuserforum.Infra.Syscode;
import com.vtxlab.bootcamp.demosbuserforum.Model.DTO.JPH.User;
import com.vtxlab.bootcamp.demosbuserforum.Service.PostService;
import com.vtxlab.bootcamp.demosbuserforum.Service.UserService;

@Service
public class UserJsonPlaceHolder implements UserService {

  @Value(value = "${api.jph.domain}")
  private String domain;

  @Value(value = "${api.jph.endpoints.user}")
  private String userEndpoint;

  @Autowired
  private PostService postService;

  @Override
  public List<User> getUsers() {
    RestTemplate restTemplate = new RestTemplate();
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



}