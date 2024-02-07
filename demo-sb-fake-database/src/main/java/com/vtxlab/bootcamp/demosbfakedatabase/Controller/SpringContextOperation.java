package com.vtxlab.bootcamp.demosbfakedatabase.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface SpringContextOperation {

  @GetMapping(value = "/beans") // noun
  String[] getBeans();

  @GetMapping(value = "/tutorname") // noun
  CharSequence getTutorName();

}