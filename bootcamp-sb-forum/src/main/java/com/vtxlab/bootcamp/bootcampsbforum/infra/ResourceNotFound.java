package com.vtxlab.bootcamp.bootcampsbforum.infra;

public class ResourceNotFound extends BusinessRuntimeException {

  public ResourceNotFound(Syscode syscode) {
    super(syscode);
  }
  
}
