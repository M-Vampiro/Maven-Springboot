package com.vtxlab.bootcamp.stockprofilefetcher.Infra;

public enum Scheme {
  HTTP, HTTPS;

  public String lowerCaseName() {
    return this.name().toLowerCase();

  }
}
