package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;

public interface PostOperation {
  
  @GetMapping(value = "/posts")
  List<Post> getPosts();

}
