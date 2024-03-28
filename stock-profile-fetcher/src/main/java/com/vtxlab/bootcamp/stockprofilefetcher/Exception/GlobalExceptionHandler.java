package com.vtxlab.bootcamp.stockprofilefetcher.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import com.vtxlab.bootcamp.stockprofilefetcher.Infra.ApiResponse;
import com.vtxlab.bootcamp.stockprofilefetcher.Infra.Syscode;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(RestClientException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResponse<Void> RCEHandler() {
    return ApiResponse.<Void>builder()
        .code(Syscode.RCException.getCode())
        .message(Syscode.RCException.getMessage())
        .build();
  }

}
