package com.vtxlab.bootcamp.stockprofilefetcher.Infra;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiResponse<T> {

  private String code;

  private String message;

  private T data;

}
