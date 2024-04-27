package com.vtxlab.cryptoandstockdatasearcher.Service;

import java.util.List;

import com.vtxlab.cryptoandstockdatasearcher.Model.ApiResponse;
import com.vtxlab.cryptoandstockdatasearcher.Model.Coin;
import com.vtxlab.cryptoandstockdatasearcher.Model.Profile2;
import com.vtxlab.cryptoandstockdatasearcher.Model.Quote;

public interface SearcherService {

  ApiResponse<List<Coin>> getAllCoins() throws Exception;

  ApiResponse<List<Coin>> getCoins() throws Exception;

  ApiResponse<Profile2> getStock() throws Exception;

  ApiResponse<Quote> getQuote() throws Exception;
  
}
