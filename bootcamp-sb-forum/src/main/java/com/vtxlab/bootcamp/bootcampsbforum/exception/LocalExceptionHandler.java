package com.vtxlab.bootcamp.bootcampsbforum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.infra.GlobalExceptionHandler;
import com.vtxlab.bootcamp.bootcampsbforum.infra.JPHClientException;

@RestControllerAdvice // Bean: @ContollerAdvice + @ResponseBody
public class LocalExceptionHandler extends GlobalExceptionHandler {

  @ExceptionHandler(JPHClientException.class) // catch
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT) // http status 408
  // @ResponseStatus is an alternative of ResponseEntity<>
  public ApiResponse<Void> jphClientExceptionHandler(JPHClientException e) {
    return ApiResponse.<Void>builder() //
        .code(e.getCode()) //
        .message(e.getMessage()) //
        .data(null) //
        .build();
  }

}
