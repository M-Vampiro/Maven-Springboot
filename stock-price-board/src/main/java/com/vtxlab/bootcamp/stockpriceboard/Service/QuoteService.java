package com.vtxlab.bootcamp.stockpriceboard.Service;

import com.vtxlab.bootcamp.stockpriceboard.Model.Quote;

public interface QuoteService {

  Quote getQuotes(String symbol) throws Exception;

}
