package com.vtxlab.bootcamp.exersicecalculator.Infra;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponce<T> {

  private String code;

  private String message;
  
}
