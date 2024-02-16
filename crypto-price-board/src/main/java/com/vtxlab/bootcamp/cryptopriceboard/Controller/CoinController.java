package com.vtxlab.bootcamp.cryptopriceboard.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vtxlab.bootcamp.cryptopriceboard.Infra.ApiResponce;
import com.vtxlab.bootcamp.cryptopriceboard.Model.DTO.JPH.Coin;

public interface CoinController {

  // https://api.coingecko.com/api/v3/coins/markets?vs_currency=gg&x_cg_demo_api_key=CG-scZ194UER4EhL9QNjs7D61Pm
  // -- the api entry

  @GetMapping(value = "/coin")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponce<List<Coin>> getCoins();
}
