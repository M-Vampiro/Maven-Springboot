package com.vtxlab.bootcamp.demosbuserforum.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

import com.vtxlab.bootcamp.demosbuserforum.Model.DTO.JPH.Post;

public interface PostOperation {
  
  @GetMapping(value = "/posts")
  List<Post> getPosts();

}