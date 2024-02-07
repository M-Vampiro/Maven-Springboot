package com.vtxlab.bootcamp.demosbuserforum.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vtxlab.bootcamp.demosbuserforum.Infra.ApiResponse;
import com.vtxlab.bootcamp.demosbuserforum.Infra.JPHClientException;
import com.vtxlab.bootcamp.demosbuserforum.Infra.ResourceNotFound;
import com.vtxlab.bootcamp.demosbuserforum.Infra.Syscode;

@RestControllerAdvice // @ContollerAdvice + @ResponseBody
public class GlobalExceptionHandler {

  @ExceptionHandler(JPHClientException.class) // catch
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)  // http status 400
  // @ResponseStatus is an alternate of ResponseEntity<>
  public ApiResponse<Void> jphClientExceptionHandler(JPHClientException e) {
    return ApiResponse.<Void>builder() //
        .code(e.getCode()) //
        .message(e.getMessage()) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(ResourceNotFound.class)
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponse<Void> npeExceptionHandler(ResourceNotFound e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.NOTFOUND.getCode()) //
        .message(Syscode.NOTFOUND.getMessage()) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(NullPointerException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResponse<Void> npeExceptionHandler(NullPointerException e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.NPE_EXCEPTION.getCode()) //
        .message(Syscode.NPE_EXCEPTION.getMessage()) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResponse<Void> npeExceptionHandler(Exception e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.GENERAL_EXCEPTION.getCode()) //
        .message(Syscode.GENERAL_EXCEPTION.getMessage()) //
        .data(null) //
        .build();
  }

}