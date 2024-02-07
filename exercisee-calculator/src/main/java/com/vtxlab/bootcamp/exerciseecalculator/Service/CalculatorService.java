package com.vtxlab.bootcamp.exerciseecalculator.Service;

import com.vtxlab.bootcamp.exerciseecalculator.Model.DTO.Compute;

public interface CalculatorService {

  Compute calculateResult(String x, String y, String operation) throws Exception;
  
}
