package com.vtxlab.bootcamp.cryptopriceboard.Controller.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.cryptopriceboard.Controller.CoinOperation;
import com.vtxlab.bootcamp.cryptopriceboard.Infra.ApiResponce;
import com.vtxlab.bootcamp.cryptopriceboard.Infra.Syscode;
import com.vtxlab.bootcamp.cryptopriceboard.Model.Coin;
import com.vtxlab.bootcamp.cryptopriceboard.Service.CoinService;

@RestController
@RequestMapping(value = "crypto/coingecto/api/v1")
public class CoinController implements CoinOperation {

  @Autowired
  private CoinService coinService;

  @Override
  public ApiResponce<List<Coin>> getAllCoins(String currency) {
    return ApiResponce.<List<Coin>>builder()
        .code(Syscode.OK.getCode())
        .message(Syscode.OK.getMessage())
        .data(coinService.getAllCoins(currency))
        .build();
  }

  @Override
  public ApiResponce<Coin> getCoin(String currency, String ids) {
    List<Coin> result = coinService.getAllCoins(currency).stream()
    .collect(Collectors.toList());

    return ApiResponce.<Coin>builder()
    .code(Syscode.OK.getCode())
    .message(Syscode.OK.getMessage())
    .data(result.get(0))
    .build();

}
}