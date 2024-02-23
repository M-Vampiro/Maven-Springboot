package com.vtxlab.bootcamp.bootcampsbforum.infra;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice // Bean: @ContollerAdvice + @ResponseBody
public class GlobalExceptionHandler {

  @ExceptionHandler(RestClientException.class) // catch
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT) // TBC.
  public ApiResponse<Void> restClientExceptionHandler(RestClientException e) {
    return ApiResponse.<Void>builder() //
        .status(Syscode.REST_CLIENT_EXCEPTION) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(ResourceNotFound.class)
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponse<Void> npeExceptionHandler(ResourceNotFound e) {
    return ApiResponse.<Void>builder() //
        .status(Syscode.NOTFOUND) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(NullPointerException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResponse<Void> npeExceptionHandler(NullPointerException e) {
    return ApiResponse.<Void>builder() //
        .status(Syscode.NPE_EXCEPTION) //
        .data(null) //
        .build();
  }

  // @ExceptionHandler(Exception.class)
  // @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  // public ApiResponse<Void> npeExceptionHandler(Exception e) {
  //   return ApiResponse.<Void>builder() //
  //       .code(Syscode.GENERAL_EXCEPTION.getCode()) //
  //       .message(Syscode.GENERAL_EXCEPTION.getMessage()) //
  //       .data(null) //
  //       .build();
  // }

}
