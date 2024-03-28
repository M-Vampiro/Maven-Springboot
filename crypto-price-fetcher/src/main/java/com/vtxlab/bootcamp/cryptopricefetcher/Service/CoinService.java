package com.vtxlab.bootcamp.cryptopricefetcher.Service;

import java.util.List;

import com.vtxlab.bootcamp.cryptopricefetcher.Model.Coin;

public interface CoinService {

  List<Coin> getAllCoins(String currency) throws Exception;

}