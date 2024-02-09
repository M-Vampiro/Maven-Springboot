package com.vtxlab.bootcamp.exersicecalculator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.vtxlab.bootcamp.exersicecalculator.Infra.ApiResponce;
import com.vtxlab.bootcamp.exersicecalculator.Infra.Syscode;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NoResourceFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ApiResponce<Void> numberFormatExceptionHandler(NoResourceFoundException e) {
    return ApiResponce.<Void>builder()
        .code(Syscode.INVALID_INPUT.getCode())
        .message(Syscode.INVALID_INPUT.getMessage())
        .build();
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponce<Void> numberFormatExceptionHandler(MissingServletRequestParameterException e) {
    return ApiResponce.<Void>builder()
        .code(Syscode.INVALID_INPUT.getCode())
        .message(Syscode.INVALID_INPUT.getMessage())
        .build();
  }

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
