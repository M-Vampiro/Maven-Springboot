package com.vtxlab.bootcamp.stockprofilefetcher.Controller.Impl;

import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.stockprofilefetcher.Controller.FinnhubOperation;
import com.vtxlab.bootcamp.stockprofilefetcher.DTO.JPH.Profile2DTO;
import com.vtxlab.bootcamp.stockprofilefetcher.DTO.JPH.QuoteDTO;
import com.vtxlab.bootcamp.stockprofilefetcher.Infra.ApiResponse;
import com.vtxlab.bootcamp.stockprofilefetcher.Infra.Syscode;
import com.vtxlab.bootcamp.stockprofilefetcher.Mapper.Mapper;
import com.vtxlab.bootcamp.stockprofilefetcher.Service.Profile2Service;
import com.vtxlab.bootcamp.stockprofilefetcher.Service.QuoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/stock/finnhub/api/v1")
public class FinnhubController implements FinnhubOperation {

  @Autowired
  Mapper mapper;

  @Autowired
  Profile2Service profile2Service;

  @Autowired
  QuoteService quoteService;

  @Override
  public ApiResponse<Profile2DTO> getProfile(String symbol) throws Exception {
    return ApiResponse.<Profile2DTO>builder()
        .code(Syscode.OK.getCode())
        .message(Syscode.OK.getMessage())
        .data(mapper.mapEntity(profile2Service.getProfile2(symbol)))
        .build();
  }

  @Override
  public ApiResponse<QuoteDTO> getQuote(String symbol) throws Exception {
    return ApiResponse.<QuoteDTO>builder()
        .code(Syscode.OK.getCode())
        .message(Syscode.OK.getMessage())
        .data(mapper.mapEntity(quoteService.getQuotes(symbol)))
        .build();

  }

}
