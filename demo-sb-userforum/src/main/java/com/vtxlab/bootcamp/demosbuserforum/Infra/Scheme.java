package com.vtxlab.bootcamp.demosbuserforum.Infra;

public enum Scheme {
  HTTPS, HTTP,;

  public String lowercaseName() {
    return this.name().toLowerCase();
  }
}
