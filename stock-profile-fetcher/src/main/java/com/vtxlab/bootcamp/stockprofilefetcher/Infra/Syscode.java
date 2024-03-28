package com.vtxlab.bootcamp.stockprofilefetcher.Infra;

import lombok.Getter;

@Getter
public enum Syscode {
  OK("000000", "OK."),
  NotFound("100000", "Not Found."),
  RCException("900000", "RestClientException - Finnhub Service is unavailable");

  private String code;

  private String message;

  private Syscode(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
