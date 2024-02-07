package com.vtxlab.bootcamp.demosbuserforum.Controller.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.demosbuserforum.Controller.PostOperation;
import com.vtxlab.bootcamp.demosbuserforum.Model.DTO.JPH.Post;
import com.vtxlab.bootcamp.demosbuserforum.Service.PostService;

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