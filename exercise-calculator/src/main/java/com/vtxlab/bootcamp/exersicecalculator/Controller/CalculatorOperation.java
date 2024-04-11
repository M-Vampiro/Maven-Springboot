package com.vtxlab.bootcamp.exersicecalculator.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.bootcamp.exersicecalculator.Model.DTO.Compute;

public interface CalculatorOperation {

  @CrossOrigin
  @GetMapping(value = "/calculate/{x}/{y}/{operation}")
  Compute calculate(@PathVariable String x, @PathVariable String y, @PathVariable String operation) throws Exception;

  @CrossOrigin
  @PostMapping(value = "/calculate")
  Compute calculate2(@RequestBody Compute compute) throws Exception;

  @CrossOrigin
  @GetMapping(value = "/calculate")
  Compute calculate3(@RequestParam(name = "x") String x, @RequestParam(name = "y") String y,
      @RequestParam(name = "operation") String operation) throws Exception;

}
