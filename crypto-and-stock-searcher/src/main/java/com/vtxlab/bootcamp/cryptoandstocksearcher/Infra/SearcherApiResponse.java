package com.vtxlab.bootcamp.cryptoandstocksearcher.Infra;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearcherApiResponse<T> {

  private String code;

  private String message;

  private T data;

}
