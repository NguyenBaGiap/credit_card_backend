package com.msb.restAdapter.controller;

import com.msb.domain.customer.models.Customer;
import com.msb.services.api.CustomerService;
import com.msb.supports.exceptions.BusinessException;
import com.msb.supports.message.MessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/public")
public class PublicController {

  final CustomerService customerService;

  public PublicController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @RequestMapping(value = "/customer/connect", method = RequestMethod.POST)
  public Customer customerConnectByMobile(@RequestParam("mobileNumber") String mobileNumber)
      throws BusinessException {
    return customerService.registerCustomer(mobileNumber);
  }

  @RequestMapping(value = "/test-message", method = RequestMethod.GET)
  public String test() throws BusinessException {
    throw new BusinessException(MessageUtil.Auth.AUTH_ACCESS_DENIED);
  }
}
