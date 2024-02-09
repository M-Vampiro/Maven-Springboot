package com.vtxlab.bootcamp.exersicecalculator.Service.Impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.vtxlab.bootcamp.exersicecalculator.Model.Operation;
import com.vtxlab.bootcamp.exersicecalculator.Model.DTO.Compute;
import com.vtxlab.bootcamp.exersicecalculator.Service.CalculatorService;


@Service

public class ServiceImpl implements CalculatorService {

  @Override
  public Compute calculateResult(String x, String y, String operation) throws Exception {
    Operation method = null;
    for (Operation m : Operation.values()) {
      if (m.toString().equals(operation.toUpperCase())) {
        method = m;
        break;
      }
    }
    BigDecimal x1 = BigDecimal.valueOf(Double.parseDouble(x));
    BigDecimal y1 = BigDecimal.valueOf(Double.parseDouble(y));
    String result = null;
    if (method != null) {
      switch (method) {
        case ADD -> result = x1.add(y1).toString();

        case SUB -> result = x1.subtract(y1).toString();

        case MUL -> result = x1.multiply(y1).toString();

        case DIV -> result = x1.divide(y1, 5, RoundingMode.HALF_UP).toString();

        default -> throw new IllegalArgumentException();
      }
    } else
      throw new IllegalArgumentException();

    return new Compute(x, y, operation.toUpperCase(), result);
  }

}