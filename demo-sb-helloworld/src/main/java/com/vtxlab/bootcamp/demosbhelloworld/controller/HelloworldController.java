package com.vtxlab.bootcamp.demosbhelloworld.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtxlab.bootcamp.demosbhelloworld.model.Cat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Web Layer, provide the capabillity at API (application progrmming interface)
@ResponseBody // JSON (Format of date transmission - System A call System B API)
@RequestMapping(value = "/api/v1") // base path of URL: version 1

public class HelloworldController {
  @GetMapping(value = "/helloworld")
  public String helloworld() {
    return "helloworld";
  }

  @GetMapping(value = "/test")
  public int test() {
    return 0;
  }

  @GetMapping(value = "/hello")
  public String hello() {
    return "Welcome to Spring Boot!!!";
  }

  // Return Cat?
  @GetMapping(value = "/Cat")
  public Cat meow() {
    return Cat.builder().age(5).name("Cha").build();
  }

  // Return List<Cat>?
  @GetMapping(value = "/Cats")
  public List<Cat> catHome() {
    // return new ArrayList<>(List.of(new Cat(3, "ABC"), new Cat(4, "DEF")));
    // return new ArrayList<Cat>(List.of(new Cat(3, "ABC"), new Cat(4, "DEF"))).stream().collect(Collectors.toList());
    return Stream.of(new Cat(3, "ABC"), new Cat(4, "DEF")).collect(Collectors.toList());
  }

  // Return Cat[]?
  @GetMapping(value = "/CatHouse")
  public Cat[] meoww() {
    return new Cat[] { new Cat(3, "ABC"), new Cat(4, "DEF") };
  }

}