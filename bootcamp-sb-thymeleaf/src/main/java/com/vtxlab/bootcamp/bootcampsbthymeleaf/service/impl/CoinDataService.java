package com.vtxlab.bootcamp.bootcampsbthymeleaf.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbthymeleaf.model.CoinData;
import com.vtxlab.bootcamp.bootcampsbthymeleaf.service.ApiService;

@Service
public class CoinDataService implements ApiService<CoinData> {

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<CoinData> fetchData() {
    String apiUrl =
        "https://api.coingecko.com/api/v3/coins/markets?ids=bitcoin,ethereum,tether&vs_currency=usd";
    CoinData[] response = restTemplate.getForObject(apiUrl, CoinData[].class);
    return Arrays.asList(response);
  }

}
