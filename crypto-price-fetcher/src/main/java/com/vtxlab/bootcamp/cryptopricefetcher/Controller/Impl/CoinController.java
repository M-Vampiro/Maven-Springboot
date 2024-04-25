package com.vtxlab.bootcamp.cryptopricefetcher.Controller.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.vtxlab.bootcamp.cryptopricefetcher.Controller.CoinOperation;
import com.vtxlab.bootcamp.cryptopricefetcher.DTO.CoinDTO;
import com.vtxlab.bootcamp.cryptopricefetcher.Infra.ApiResponse;
import com.vtxlab.bootcamp.cryptopricefetcher.Infra.Syscode;
import com.vtxlab.bootcamp.cryptopricefetcher.Mapper.Mapper;
import com.vtxlab.bootcamp.cryptopricefetcher.Service.CoinService;

@RestController
@RequestMapping(value = "crypto/coingecko/api/v1")
public class CoinController implements CoinOperation {

  @Autowired
  private CoinService coinService;

  @Autowired
  private Mapper mapper;

  @Override
  public ApiResponse<List<CoinDTO>> getAllCoins(String currency, String ids) throws Exception {

    List<CoinDTO> result = ids == null ? coinService.getAllCoins(currency).stream()
        .map(e -> mapper.mapEntity(e))
        .collect(Collectors.toList())
        : coinService.getAllCoins(currency).stream()
            .filter(e -> ids.contains(e.getId()))
            .map(e -> mapper.mapEntity(e))
            .collect(Collectors.toList());
    if (ids != null)
      if (result.size() == 0 || result.size() != ids.split(",").length)
        throw new RestClientException(Syscode.RCException.getMessage());
    return ApiResponse.<List<CoinDTO>>builder()
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