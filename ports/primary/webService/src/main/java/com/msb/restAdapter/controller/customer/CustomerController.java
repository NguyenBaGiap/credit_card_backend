package com.msb.restAdapter.controller.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/private/customer")
public class CustomerController {

  @RequestMapping(value = "/info", method = RequestMethod.GET)
  public String resolveCurrentCustomer() {
    return "information current customer session";
  }

  @RequestMapping(value = "/confirm-otp", method = RequestMethod.POST)
  public String confirmOtpByCustomer() {
    return "api confirm otp step 02";
  }

  @RequestMapping(value = "/address", method = RequestMethod.POST)
  public String registerCurrentAddressOfCustomer() {
    return "api submit current address";
  }

}
