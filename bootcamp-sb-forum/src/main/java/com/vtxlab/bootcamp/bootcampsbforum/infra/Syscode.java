package com.vtxlab.bootcamp.bootcampsbforum.infra;

import lombok.Getter;

@Getter
public enum Syscode {
  OK("000000", "OK."), //
  NOTFOUND("100000", "Not Found."), //
  JPH_NOT_AVAILABLE("100001", "JsonPlaceHolder API is unavailable."), //

  // Runtime Exception
  REST_CLIENT_EXCEPTION("900001", "RestClient Exception."), //
  NPE_EXCEPTION("900000", "Runtime Exception - NPE."), //
  REQUEST_PARAM_EXCEPTION("900002", "Invalid Request Parameter/ Body."), //
  GENERAL_EXCEPTION("999999", "General Exception.");

  //


  private String code;
  private String message;

  private Syscode(String code, String message) {
    this.code = code;
    this.message = message;
  }

}
