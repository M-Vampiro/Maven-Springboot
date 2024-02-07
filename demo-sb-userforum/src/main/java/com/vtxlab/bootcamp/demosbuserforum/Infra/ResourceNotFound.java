package com.vtxlab.bootcamp.demosbuserforum.Infra;

public class ResourceNotFound extends BusinessRuntimeException {

  public ResourceNotFound(Syscode syscode) {
    super(syscode);
  }
  
}