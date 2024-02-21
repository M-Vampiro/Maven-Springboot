package com.vtxlab.bootcamp.stockpriceboard.Controller.Impl;

import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.stockpriceboard.Controller.FinnhubOperation;
import com.vtxlab.bootcamp.stockpriceboard.DTO.JPH.Profile2DTO;
import com.vtxlab.bootcamp.stockpriceboard.DTO.JPH.QuoteDTO;
import com.vtxlab.bootcamp.stockpriceboard.Infra.ApiResponse;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value = "/stock/finnhub/api/v1")
public class FinnhubController implements FinnhubOperation{

  @Override
  ApiResponse<Profile2DTO> getProfile(String symbol) {

  }

  @Override
  ApiResponse<QuoteDTO> getQuote(String symbol) {

  }
  
}
