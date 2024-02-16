package com.vtxlab.bootcamp.cryptopriceboard.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vtxlab.bootcamp.cryptopriceboard.Infra.ApiResponce;
import com.vtxlab.bootcamp.cryptopriceboard.Infra.Currency;
import com.vtxlab.bootcamp.cryptopriceboard.Model.Coin;

public interface CoinOperation {

  // https://api.coingecko.com/api/v3/coins/markets?vs_currency=gg&x_cg_demo_api_key=CG-scZ194UER4EhL9QNjs7D61Pm
  // -- the api entry

  @GetMapping(value = "/markets")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponce<List<Coin>> getAllCoins(@RequestParam(name = "currency",required = true) String currency);

  @GetMapping(value = "/coins")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponce<Coin> getCoin(@RequestParam(name = "currency",required = true) String currency, @RequestParam(name = "ids", required = false) String ids);
}
