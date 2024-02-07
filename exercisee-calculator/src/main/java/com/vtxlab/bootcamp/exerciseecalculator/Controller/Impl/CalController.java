package com.vtxlab.bootcamp.exerciseecalculator.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.exerciseecalculator.Controller.CalculatorOperation;
import com.vtxlab.bootcamp.exerciseecalculator.Model.DTO.Compute;
import com.vtxlab.bootcamp.exerciseecalculator.Service.Impl.ServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class CalController implements CalculatorOperation {

  @Autowired
  private ServiceImpl serviceImpl;

  @Override
  public Compute calculate(String x, String y, String operation) throws Exception {
    return serviceImpl.calculateResult(x, y, operation);
  }

  @Override
  public Compute calculate2(Compute compute) throws Exception {
    return serviceImpl.calculateResult(compute.getX(), compute.getY(), compute.getOperation());
  }

  @Override
  public Compute calculate3(String x, String y, String operation) throws Exception {

    return serviceImpl.calculateResult(x, y, operation);
  }

}
