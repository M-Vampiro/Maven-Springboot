package com.vtxlab.bootcamp.cryptopriceboard.Service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vtxlab.bootcamp.cryptopriceboard.Infra.BcUtil;
import com.vtxlab.bootcamp.cryptopriceboard.Infra.Scheme;
import com.vtxlab.bootcamp.cryptopriceboard.Model.Coin;
import com.vtxlab.bootcamp.cryptopriceboard.Service.CoinService;

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
  public List<Coin> getAllCoins(String currency) {
    String marketUrl = BcUtil.url(Scheme.HTTPS, domain, marketsEndpoint, currency, key);

    Coin[] coins = restTemplate.getForObject(marketUrl, Coin[].class);

    return Arrays.stream(coins)
        .collect(Collectors.toList());
  }

}
