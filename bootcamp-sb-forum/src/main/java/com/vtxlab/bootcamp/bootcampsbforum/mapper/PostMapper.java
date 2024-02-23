package com.vtxlab.bootcamp.bootcampsbforum.mapper;

import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bootcampsbforum.dto.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.PostEntity;

@Component // -> Bean
public class PostMapper {

  public PostEntity mapEntity(UserPostRequestDTO.PostRequestDTO dto) {
    return PostEntity.builder() //
        .title(dto.getTitle()) //
        .body(dto.getBody()) //
        .build();
  }
}
