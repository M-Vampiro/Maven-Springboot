package com.vtxlab.bootcamp.exersicecalculator.Infra;

import lombok.Getter;

@Getter
public enum Syscode {

  INVALID_INPUT("9", "Invalid Input.");

  private String code;
  private String message;

  private Syscode(String code, String message) {
    this.code = code;
    this.message = message;
  }

}
