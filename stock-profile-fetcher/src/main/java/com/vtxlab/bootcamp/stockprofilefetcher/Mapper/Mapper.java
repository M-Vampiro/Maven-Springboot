package com.vtxlab.bootcamp.stockprofilefetcher.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vtxlab.bootcamp.stockprofilefetcher.DTO.JPH.Profile2DTO;
import com.vtxlab.bootcamp.stockprofilefetcher.DTO.JPH.QuoteDTO;
import com.vtxlab.bootcamp.stockprofilefetcher.Model.Profile2;
import com.vtxlab.bootcamp.stockprofilefetcher.Model.Quote;

@Component
public class Mapper {

  @Autowired
  private ModelMapper modelMapper;

  public QuoteDTO map(Quote quote) {
    return this.modelMapper.map(quote, QuoteDTO.class);
  }

  public QuoteDTO mapEntity(Quote quote) {
    return QuoteDTO.builder()
        .c(quote.getC())
        .d(quote.getD())
        .dp(quote.getDp())
        .h(quote.getH())
        .l(quote.getL())
        .o(quote.getO())
        .pc(quote.getPc())
        .build();
  }

  public Profile2DTO map(Profile2 profile2) {
    return this.modelMapper.map(profile2, Profile2DTO.class);
  }

  public Profile2DTO mapEntity(Profile2 profile2) {
    return Profile2DTO.builder()
        .country(profile2.getCountry())
        .currency(profile2.getCurrency())
        .exchange(profile2.getExchange())
        .finnhubindustry(profile2.getFinnhubindustry())
        .ipo(profile2.getIpo())
        .logo(profile2.getLogo())
        .marketCapitalization(profile2.getMarketCapitalization())
        .name(profile2.getName())
        .phone(profile2.getPhone())
        .shareOutstanding(profile2.getShareOutstanding())
        .ticker(profile2.getTicker())
        .weburl(profile2.getWeburl())
        .build();

  }

}
