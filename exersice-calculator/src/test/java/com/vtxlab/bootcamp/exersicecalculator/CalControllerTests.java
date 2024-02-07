package com.vtxlab.bootcamp.exersicecalculator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.exersicecalculator.Controller.Impl.CalController;
import com.vtxlab.bootcamp.exersicecalculator.Model.DTO.Compute;
import com.vtxlab.bootcamp.exersicecalculator.Service.Impl.ServiceImpl;

@WebMvcTest(CalController.class)
public class CalControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ServiceImpl serviceImpl;

  @Test
  void testCalculatorAdd() throws Exception {
    Compute mockedReturnCompute = new Compute("10", "10", "ADD", "20.0");

    Mockito.when(serviceImpl.calculateResult("10", "10", "add")).thenReturn(mockedReturnCompute);

    mockMvc.perform(get("/api/v1/calculate/{x}/{y}/{operation}", "10", "10", "add"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.x").value("10"))
        .andExpect(jsonPath("$.y").value("10"))
        .andExpect(jsonPath("$.operation").value("ADD"))
        .andExpect(jsonPath("$.result").value("20.0"))
        .andDo(print());
  }

  @Test
  void testCalculatorSubtract() throws Exception {
    Compute mockedReturnCompute = new Compute("10", "10", "SUB", "0.0");

    Mockito.when(serviceImpl.calculateResult("10", "10", "sub")).thenReturn(mockedReturnCompute);

    mockMvc.perform(get("/api/v1/calculate?x=10&y=10&operation=sub"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.x").value("10"))
        .andExpect(jsonPath("$.y").value("10"))
        .andExpect(jsonPath("$.operation").value("SUB"))
        .andExpect(jsonPath("$.result").value("0.0"))
        .andDo(print());
  }

  @Test
  void testCalculatorMultiply() throws Exception {
    Compute mockedReturnCompute = new Compute("10", "10", "MUL", "100.00");
    Compute mockedRequest = new Compute("10", "10", "mul", null);

    String contentString = new ObjectMapper().writeValueAsString(mockedRequest);

    Mockito.when(serviceImpl.calculateResult("10", "10", "mul")).thenReturn(mockedReturnCompute);

    mockMvc.perform(post("/api/v1/calculate")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(contentString))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.x").value("10"))
        .andExpect(jsonPath("$.y").value("10"))
        .andExpect(jsonPath("$.operation").value("MUL"))
        .andExpect(jsonPath("$.result").value("100.00"))
        .andDo(print());
  }

  @Test
  void testCalculatorDivide() throws Exception {
    Compute mockedReturnCompute = new Compute("10", "10", "DIV", "1.00000");
    Compute mockedRequest = new Compute("10", "10", "div", null);

    String contentString = new ObjectMapper().writeValueAsString(mockedRequest);

    Mockito.when(serviceImpl.calculateResult("10", "10", "div")).thenReturn(mockedReturnCompute);

    mockMvc.perform(post("/api/v1/calculate")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(contentString))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.x").value("10"))
        .andExpect(jsonPath("$.y").value("10"))
        .andExpect(jsonPath("$.operation").value("DIV"))
        .andExpect(jsonPath("$.result").value("1.00000"))
        .andDo(print());
  }

}
