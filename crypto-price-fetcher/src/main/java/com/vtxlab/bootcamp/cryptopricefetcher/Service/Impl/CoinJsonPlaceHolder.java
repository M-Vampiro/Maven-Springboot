package com.vtxlab.bootcamp.cryptopricefetcher.Service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.vtxlab.bootcamp.cryptopricefetcher.Infra.BcUtil;
import com.vtxlab.bootcamp.cryptopricefetcher.Infra.Currency;
import com.vtxlab.bootcamp.cryptopricefetcher.Infra.Scheme;
import com.vtxlab.bootcamp.cryptopricefetcher.Infra.Syscode;
import com.vtxlab.bootcamp.cryptopricefetcher.Model.Coin;
import com.vtxlab.bootcamp.cryptopricefetcher.Service.CoinService;

@Service
public class CoinJsonPlaceHolder implements CoinService {

  @Value(value = "${api.coingecko.domain}")
  private String domain;

  @Value(value = "${api.coingecko.endpoints.markets}")
  private String marketsEndpoint;

  @Value(value = "${api.coingecko.key}")
  private String key;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Coin> getAllCoins(String currency) throws Exception {

    String marketUrl = null;

    for (Currency c : Currency.values()) {
      if (c.lowerCaseName().equals(currency.toLowerCase()))
        marketUrl = BcUtil.url(Scheme.HTTPS, domain, marketsEndpoint, currency.toLowerCase(), key);
    }
    if (marketUrl == null)
      throw new RestClientException(Syscode.RCException.getMessage());

    Coin[] coins = restTemplate.getForObject(marketUrl, Coin[].class);

    return Arrays.stream(coins)
        .collect(Collectors.toList());
  }

}
