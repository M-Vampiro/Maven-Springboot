package com.vtxlab.bootcamp.cryptopriceboard.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import com.vtxlab.bootcamp.cryptopriceboard.Infra.ApiResponce;
import com.vtxlab.bootcamp.cryptopriceboard.Infra.Syscode;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(RestClientException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResponce<Void> restClientExceptionHandler(RestClientException e) {
    return ApiResponce.<Void>builder()
    .code(Syscode.RCException.getCode())
    .message(Syscode.RCException.getMessage())
    .data(null)
    .build();
  }
  
}
