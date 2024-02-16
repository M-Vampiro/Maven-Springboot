package com.vtxlab.bootcamp.cryptopriceboard.Infra;

import lombok.Getter;

@Getter
public enum Syscode {
  OK("000000", "OK."),
  NotFound("100000", "Not Found."),
  RCException("900000", "RestClientException - Coingecto Service is unavailable");

  private String code;

  private String message;

  private Syscode(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
