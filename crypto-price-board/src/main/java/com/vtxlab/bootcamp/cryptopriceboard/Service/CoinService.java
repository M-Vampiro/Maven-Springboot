package com.vtxlab.bootcamp.cryptopriceboard.Service;

import java.util.List;

import com.vtxlab.bootcamp.cryptopriceboard.Model.Coin;

public interface CoinService {

  List<Coin> getAllCoins(String currency) throws Exception;

}