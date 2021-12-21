package com.msb.services.api;

import com.msb.domain.customer.models.Customer;
import com.msb.domain.security.service.customer.CustomerDetailsService;
import com.msb.supports.exceptions.BusinessException;

public interface CustomerService extends CustomerDetailsService {
  Customer registerCustomer(String mobileNumber) throws BusinessException;
}
