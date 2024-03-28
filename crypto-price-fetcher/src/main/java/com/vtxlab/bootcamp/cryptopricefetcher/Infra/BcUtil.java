package com.vtxlab.bootcamp.cryptopricefetcher.Infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {

  public static String url(Scheme scheme, String domain, String endpoint, String currency, String key) {
    return UriComponentsBuilder.newInstance()
        .scheme(scheme.lowerCaseName())
        .host(domain)
        .path(endpoint)
        .queryParam("vs_currency", currency)
        .queryParam("x_cg_demo_api_key", key)
        .toUriString();
  }

}
