package com.vtxlab.bootcamp.demosbfakedatabase.Controller.impl;

import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.bootcamp.demosbfakedatabase.DemoSbFakeDatabaseApplication;
import com.vtxlab.bootcamp.demosbfakedatabase.Controller.SpringContextOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/api/v1")
public class SpringContextController implements SpringContextOperation {

  @Autowired
  @Qualifier(value = "tutor2")
  private CharSequence tutorName;

  @Override
  public String[] getBeans() {
    return DemoSbFakeDatabaseApplication //
        .getSpringContext() //
        .getBeanDefinitionNames();
  }

  //
  @Override
  public CharSequence getTutorName() {
    return this.tutorName;
  }

}