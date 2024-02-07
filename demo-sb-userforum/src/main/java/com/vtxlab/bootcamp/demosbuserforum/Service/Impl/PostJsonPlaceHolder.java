package com.vtxlab.bootcamp.demosbuserforum.Service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vtxlab.bootcamp.demosbuserforum.Infra.BcUtil;
import com.vtxlab.bootcamp.demosbuserforum.Infra.Scheme;
import com.vtxlab.bootcamp.demosbuserforum.Model.DTO.JPH.Post;
import com.vtxlab.bootcamp.demosbuserforum.Service.PostService;

@Service
public class PostJsonPlaceHolder implements PostService {

  @Value(value = "${api.jph.domain}")
  private String domain;

  @Value(value = "${api.jph.endpoints.post}")
  private String postEndpoint;

  @Override
  public List<Post> getPosts() {
    RestTemplate restTemplate = new RestTemplate();
    String postUrl = BcUtil.url(Scheme.HTTPS, domain, postEndpoint);
    Post[] posts = restTemplate.getForObject(postUrl, Post[].class);

    return Arrays.stream(posts) //
        .collect(Collectors.toList());
  }

}