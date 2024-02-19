package com.vtxlab.bootcamp.cryptopriceboard.Controller.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

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
  public ApiResponce<List<Coin>> getAllCoins(String currency, String ids) throws Exception {

    List<Coin> result = ids == null ? coinService.getAllCoins(currency)
        : coinService.getAllCoins(currency).stream()
            .filter(e -> ids.contains(e.getId()))
            .collect(Collectors.toList());
    if (ids != null)
      if (result.size() == 0 || result.size() != ids.split(",").length)
        throw new RestClientException(Syscode.RCException.getMessage());
    return ApiResponce.<List<Coin>>builder()
        .code(Syscode.OK.getCode())
        .message(Syscode.OK.getMessage())
        .data(result)
        .build();

    // Ver 1.0
    // return ids == null ? ApiResponce.<List<Coin>>builder()
    // .code(Syscode.OK.getCode())
    // .message(Syscode.OK.getMessage())
    // .data(coinService.getAllCoins(currency))
    // .build()
    // : ApiResponce.<List<Coin>>builder()
    // .code(Syscode.OK.getCode())
    // .message(Syscode.OK.getMessage())
    // .data(
    // coinService.getAllCoins(currency).stream()
    // .filter(e -> ids.contains(e.getId()))
    // .collect(Collectors.toList()))
    // .build();
  }

}