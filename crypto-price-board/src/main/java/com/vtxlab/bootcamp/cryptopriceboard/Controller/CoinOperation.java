package com.vtxlab.bootcamp.cryptopriceboard.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vtxlab.bootcamp.cryptopriceboard.Infra.ApiResponce;
import com.vtxlab.bootcamp.cryptopriceboard.Model.Coin;

public interface CoinOperation {

  @GetMapping(value = "/coins")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponce<List<Coin>> getAllCoins(@RequestParam(name = "currency",required = true) String currency, @RequestParam(name = "ids", required = false) String ids) throws Exception;
}
