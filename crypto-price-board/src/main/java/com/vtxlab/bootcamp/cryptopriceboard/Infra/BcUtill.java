package com.vtxlab.bootcamp.cryptopriceboard.Infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtill {

  public static String url(Scheme scheme, String domain, String endpoint) {
    return UriComponentsBuilder.newInstance()
        .scheme(scheme.lowerCaseName())
        .host(domain)
        .path(endpoint)
        .toUriString();
  }

}
