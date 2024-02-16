package com.vtxlab.bootcamp.cryptopriceboard.Infra;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponce<T> {

  private String code;

  private String message;

  private T data;

}
