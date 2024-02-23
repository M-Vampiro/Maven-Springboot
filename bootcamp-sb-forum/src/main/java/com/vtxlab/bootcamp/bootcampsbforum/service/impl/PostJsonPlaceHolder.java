package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbforum.infra.BcUtil;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;

@Service
public class PostJsonPlaceHolder implements PostService {

  @Value(value = "${api.jph.domain}")
  private String domain;

  @Value(value = "${api.jph.endpoints.post}")
  private String postEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Post> getPostsFromJPH() {
    // RestTemplate restTemplate = new RestTemplate();
    String postUrl = BcUtil.url(Scheme.HTTPS, domain, postEndpoint);

    Post[] posts = restTemplate.getForObject(postUrl, Post[].class);
    return Arrays.stream(posts) //
        .collect(Collectors.toList());
  }

}
