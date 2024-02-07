package com.vtxlab.bootcamp.demosbuserforum.Infra;

public class BusinessException extends Exception {

  private String code;

  public BusinessException(Syscode syscode) {
    super(syscode.getMessage());
    this.code = syscode.getCode();
  }
  
}