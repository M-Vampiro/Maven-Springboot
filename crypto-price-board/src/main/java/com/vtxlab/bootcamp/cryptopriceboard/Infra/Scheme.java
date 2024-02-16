package com.vtxlab.bootcamp.cryptopriceboard.Infra;

public enum Scheme {
  HTTP, HTTPS;

  public String lowerCaseName() {
    return this.name().toLowerCase();

  }
}
