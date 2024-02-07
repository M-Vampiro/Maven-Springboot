package com.vtxlab.bootcamp.demosbuserforum.Infra;

public class JPHClientException extends BusinessRuntimeException {

  public JPHClientException(Syscode syscode) {
    super(syscode);
  }

}