package com.vtxlab.bootcamp.cryptopriceboard;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.vtxlab.bootcamp.cryptopriceboard.Controller.Impl.CoinController;
import com.vtxlab.bootcamp.cryptopriceboard.Service.Impl.CoinJsonPlaceHolder;

@WebMvcTest(CoinController.class)
public class JsonPlaceHolderTest {
  
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CoinJsonPlaceHolder coinJsonPlaceHolder;

  @Test
  void testBody() throws Exception {
    mockMvc.perform(get("/crypto/coingecto/api/v1/coins?currency=usd"))
    .andExpect(status().isOk())
    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
    .andExpect(jsonPath("$.code").value("000000"))
    .andExpect(jsonPath("$.message").value("OK."))
    .andDo(print());
  }
}
