package com.msb.restAdapter.controller;

import com.msb.domain.customer.models.Customer;
import com.msb.restAdapter.models.request.CustomerLoginRequest;
import com.msb.services.api.CustomerService;
import com.msb.supports.exceptions.BusinessException;
import com.msb.supports.message.MessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Slf4j
@Validated
@RestController
@RequestMapping(value = "/api/public")
public class PublicController {

  final CustomerService customerService;

  public PublicController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @RequestMapping(value = "/customer/login", method = RequestMethod.POST)
  public Customer customerConnectByMobile(@RequestBody @Valid CustomerLoginRequest request)
      throws BusinessException {
    log.info(request.toString());
    return null;
  }

  @RequestMapping(value = "/test-message", method = RequestMethod.GET)
  public String test() throws BusinessException {
    throw new BusinessException(MessageUtil.Auth.AUTH_ACCESS_DENIED);
  }
}
