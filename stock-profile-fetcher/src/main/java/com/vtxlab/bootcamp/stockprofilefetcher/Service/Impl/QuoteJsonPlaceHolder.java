package com.vtxlab.bootcamp.stockprofilefetcher.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.vtxlab.bootcamp.stockprofilefetcher.Infra.BcUtil;
import com.vtxlab.bootcamp.stockprofilefetcher.Infra.Scheme;
import com.vtxlab.bootcamp.stockprofilefetcher.Infra.Syscode;
import com.vtxlab.bootcamp.stockprofilefetcher.Model.Quote;
import com.vtxlab.bootcamp.stockprofilefetcher.Service.QuoteService;

@Service
public class QuoteJsonPlaceHolder implements QuoteService {

  @Value(value = "${api.finnhub.domain}")
  private String domain;

  @Value(value = "${api.finnhub.endpoints.quote}")
  private String quoteEndpoint;

  @Value(value = "${api.finnhub.key}")
  private String key;

  @Autowired
  private RestTemplate restTemplate;

  @SuppressWarnings("null")
  @Override
  public Quote getQuotes(String symbol) throws Exception {
    String quoteUrl = BcUtil.quoteUrl(Scheme.HTTPS, domain, quoteEndpoint, symbol.toUpperCase(), key);

    Quote quote = restTemplate.getForObject(quoteUrl, Quote.class);
    if (quote.getD() == null || quote.getDp() == null)
      throw new RestClientException(Syscode.RCException.getMessage());

    return quote;

  }

}
