package com.vtxlab.bootcamp.exersicecalculator.Infra;

import lombok.Getter;

@Getter
public enum Syscode {

  OK("200", "OK"),
  INVALID_INPUT("09", "Invalid Input.");

  private String code;
  private String message;

  private Syscode(String code, String message) {
    this.code = code;
    this.message = message;
  }
  
}
