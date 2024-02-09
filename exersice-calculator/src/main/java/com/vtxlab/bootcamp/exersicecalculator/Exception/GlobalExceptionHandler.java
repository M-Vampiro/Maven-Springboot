package com.vtxlab.bootcamp.exersicecalculator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vtxlab.bootcamp.exersicecalculator.Infra.ApiResponce;
import com.vtxlab.bootcamp.exersicecalculator.Infra.Syscode;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NumberFormatException.class)
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponce<Void> numberFormatExceptionHandler(NumberFormatException e) {
    return ApiResponce.<Void>builder()
        .code(Syscode.INVALID_INPUT.getCode())
        .message(Syscode.INVALID_INPUT.getMessage())
        .build();
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponce<Void> IAEHandler(IllegalArgumentException e) {
    return ApiResponce.<Void>builder()
        .code(Syscode.INVALID_INPUT.getCode())
        .message(Syscode.INVALID_INPUT.getMessage())
        .build();
  }

  @ExceptionHandler(ArithmeticException.class)
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponce<Void> arithmeticExceptionHandler(ArithmeticException e) {
    return ApiResponce.<Void>builder()
        .code(Syscode.INVALID_INPUT.getCode())
        .message(Syscode.INVALID_INPUT.getMessage())
        .build();
  }

}
