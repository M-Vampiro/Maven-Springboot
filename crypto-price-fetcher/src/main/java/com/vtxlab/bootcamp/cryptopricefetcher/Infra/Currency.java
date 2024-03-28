package com.vtxlab.bootcamp.cryptopricefetcher.Infra;

public enum Currency {
  USD,;

  public String lowerCaseName() {
    return this.name().toLowerCase();
  }
}
