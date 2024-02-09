package com.vtxlab.bootcamp.exersicecalculator.Service;

import com.vtxlab.bootcamp.exersicecalculator.Model.DTO.Compute;

public interface CalculatorService {

  Compute calculateResult(String x, String y, String operation) throws Exception;
  
}
