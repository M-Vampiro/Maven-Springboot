package com.vtxlab.bootcamp.cryptoandstocksearcher.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface SearcherOperation {

  @GetMapping(value = "/coins")
  @ResponseStatus(value = HttpStatus.OK)
  

  @GetMapping(value = "/stocks")
  @ResponseStatus(value = HttpStatus.OK)


  @GetMapping(value = "/quote")
  @ResponseStatus(value = HttpStatus.OK)


  @GetMapping(value = "/search")
  @ResponseStatus(value = HttpStatus.OK)

  
  

  
  
}
