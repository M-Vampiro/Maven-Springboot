package com.vtxlab.bootcamp.stockprofilefetcher.Infra;

import org.springframework.web.util.UriComponentsBuilder;

@SuppressWarnings("null")
public class BcUtil {

  public static String quoteUrl(Scheme scheme, String domain, String quoteEndpoint, String symbol, String key) {
    return UriComponentsBuilder.newInstance()
        .scheme(scheme.lowerCaseName())
        .host(domain)
        .path(quoteEndpoint)
        .queryParam("symbol", symbol)
        .queryParam("token", key)
        .toUriString();
  }

  public static String profile2Url(Scheme scheme, String domain, String profile2Endpoint, String symbol, String key) {
    return UriComponentsBuilder.newInstance()
        .scheme(scheme.lowerCaseName())
        .host(domain)
        .path(profile2Endpoint)
        .queryParam("symbol", symbol)
        .queryParam("token", key)
        .toUriString();
  }

}
