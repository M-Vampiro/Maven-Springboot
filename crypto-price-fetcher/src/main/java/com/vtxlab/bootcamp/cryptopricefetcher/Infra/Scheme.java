package com.vtxlab.bootcamp.cryptopricefetcher.Infra;

public enum Scheme {
  HTTP, HTTPS;

  public String lowerCaseName() {
    return this.name().toLowerCase();

  }
}
