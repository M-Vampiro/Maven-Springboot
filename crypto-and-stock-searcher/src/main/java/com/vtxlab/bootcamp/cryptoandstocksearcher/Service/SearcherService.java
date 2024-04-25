package com.vtxlab.bootcamp.cryptoandstocksearcher.Service;

import java.util.List;

import com.vtxlab.bootcamp.cryptoandstocksearcher.Model.ApiResponse;
import com.vtxlab.bootcamp.cryptoandstocksearcher.Model.Coin;
import com.vtxlab.bootcamp.cryptoandstocksearcher.Model.Profile2;
import com.vtxlab.bootcamp.cryptoandstocksearcher.Model.Quote;

public interface SearcherService {

  ApiResponse<List<Coin>> getAllCoins() throws Exception;

  ApiResponse<List<Coin>> getCoins() throws Exception;

  ApiResponse<Profile2> getStock() throws Exception;

  ApiResponse<Quote> getQuote() throws Exception;
  
}
