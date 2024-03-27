package com.vtxlab.bootcamp.bootcampsbthymeleaf.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.vtxlab.bootcamp.bootcampsbthymeleaf.model.CoinData;
import com.vtxlab.bootcamp.bootcampsbthymeleaf.service.ApiService;

@Controller
@RequestMapping(value = "/api/v1")
public class HelloworldController {

  @Autowired
  private ApiService<CoinData> apiService;

  @GetMapping(value = "/hello")
  public String displayHelloPage(Model model) { // pass-by-reference
    // define variable for html use
    model.addAttribute("greetingMessage", "Hello World! ...");
    model.addAttribute("greetingMessage2", "ABCDEFG");
    return "hello-world"; // hello-world.html
  }

  @GetMapping(value = "/coindata")
  public String displayCoinData(Model model) {
    List<CoinData> coinDataList = apiService.fetchData();
    model.addAttribute("coinDataList", coinDataList);
    return "coin-data"; // coin-data.html
  }

}
