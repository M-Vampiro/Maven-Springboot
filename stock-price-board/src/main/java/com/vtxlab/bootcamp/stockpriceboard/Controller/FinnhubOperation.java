package com.vtxlab.bootcamp.stockpriceboard.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vtxlab.bootcamp.stockpriceboard.DTO.JPH.Profile2DTO;
import com.vtxlab.bootcamp.stockpriceboard.DTO.JPH.QuoteDTO;
import com.vtxlab.bootcamp.stockpriceboard.Infra.ApiResponse;

public interface FinnhubOperation {

  @GetMapping(value = "/profile2")
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponse<Profile2DTO> getProfile(@RequestParam(name = "symbol", required = true) String symbol);

  @GetMapping(value = "/quote")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<QuoteDTO> getQuote(@RequestParam(name = "symbol", required = true) String symbol);

}
