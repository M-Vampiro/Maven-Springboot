package com.vtxlab.bootcamp.stockprofilefetcher.Service;

import com.vtxlab.bootcamp.stockprofilefetcher.Model.Quote;

public interface QuoteService {

  Quote getQuotes(String symbol) throws Exception;

}
