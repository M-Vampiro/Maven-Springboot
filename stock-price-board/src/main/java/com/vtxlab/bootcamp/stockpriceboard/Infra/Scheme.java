package com.vtxlab.bootcamp.stockpriceboard.Infra;

public enum Scheme {
  HTTP, HTTPS;

  public String lowerCaseName() {
    return this.name().toLowerCase();

  }
}
