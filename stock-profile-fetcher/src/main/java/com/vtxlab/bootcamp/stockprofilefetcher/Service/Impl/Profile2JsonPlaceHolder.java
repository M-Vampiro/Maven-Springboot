package com.vtxlab.bootcamp.stockprofilefetcher.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.vtxlab.bootcamp.stockprofilefetcher.Infra.BcUtil;
import com.vtxlab.bootcamp.stockprofilefetcher.Infra.Scheme;
import com.vtxlab.bootcamp.stockprofilefetcher.Infra.Syscode;
import com.vtxlab.bootcamp.stockprofilefetcher.Model.Profile2;
import com.vtxlab.bootcamp.stockprofilefetcher.Service.Profile2Service;

@Service
public class Profile2JsonPlaceHolder implements Profile2Service {

  @Value(value = "${api.finnhub.domain}")
  private String domain;

  @Value(value = "${api.finnhub.endpoints.profile2}")
  private String profile2Endpoint;

  @Value(value = "${api.finnhub.key}")
  private String key;

  @Autowired
  private RestTemplate restTemplate;

  @SuppressWarnings("null")
  @Override
  public Profile2 getProfile2(String symbol) throws Exception {
    String profile2Url = BcUtil.quoteUrl(Scheme.HTTPS, domain, profile2Endpoint, symbol.toUpperCase(), key);

    Profile2 profile2 = restTemplate.getForObject(profile2Url, Profile2.class);
    if (profile2.getCountry() == null)
      throw new RestClientException(Syscode.RCException.getMessage());

    return profile2;

  }

}
