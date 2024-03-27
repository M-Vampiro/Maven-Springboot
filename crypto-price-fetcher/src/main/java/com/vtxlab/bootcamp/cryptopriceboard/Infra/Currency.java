package com.vtxlab.bootcamp.cryptopriceboard.Infra;

public enum Currency {
  USD,;

  public String lowerCaseName() {
    return this.name().toLowerCase();
  }
}
