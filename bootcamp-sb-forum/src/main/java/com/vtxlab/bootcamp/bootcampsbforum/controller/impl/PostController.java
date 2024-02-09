package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.PostOperation;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;

@RestController
@RequestMapping(value = "/api/v1")
public class PostController implements PostOperation {
  
  @Autowired
  private PostService postService;

  @Override
  public List<Post> getPosts() {
    return postService.getPosts();
  }
}
