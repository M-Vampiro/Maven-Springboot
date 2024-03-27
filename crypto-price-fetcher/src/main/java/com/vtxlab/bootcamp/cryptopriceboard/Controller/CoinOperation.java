package com.vtxlab.bootcamp.cryptopriceboard.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vtxlab.bootcamp.cryptopriceboard.DTO.CoinDTO;
import com.vtxlab.bootcamp.cryptopriceboard.Infra.ApiResponse;

public interface CoinOperation {

  @GetMapping(value = "/coins")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<CoinDTO>> getAllCoins(@RequestParam(name = "currency",required = true) String currency, @RequestParam(name = "ids", required = false) String ids) throws Exception;
}
