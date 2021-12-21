package com.msb.restAdapter.controller.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/private")
public class CustomerController {
  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public String testPrivateController() {
    return "test private api";
  }
}
