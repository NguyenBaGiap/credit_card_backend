package com.msb.services.adapter;

import com.msb.domain.customer.CustomerPersistencePort;
import com.msb.domain.customer.models.Customer;
import com.msb.domain.security.models.customer.CustomerUserDetails;
import com.msb.services.api.CustomerService;
import com.msb.supports.exceptions.BusinessException;
import com.msb.supports.message.MessageUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class CustomerServiceAdapter implements CustomerService {
  final CustomerPersistencePort customerPersistencePort;

  public CustomerServiceAdapter(CustomerPersistencePort customerPersistencePort) {
    this.customerPersistencePort = customerPersistencePort;
  }

  @Override
  public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException {
    return customerPersistencePort
        .findByMobileNumber(mobileNumber)
        .map(CustomerUserDetails::new)
        .orElseThrow(() -> new UsernameNotFoundException(MessageUtil.Customer.CUSTOMER_NOT_FOUND));
  }

  @Override
  @Transactional
  public Customer registerCustomer(String mobileNumber) throws BusinessException {
    Customer customer =
        customerPersistencePort
            .findByMobileNumber(mobileNumber)
            .orElse(Customer.builder().mobileNumber(mobileNumber).build());
    return customerPersistencePort.save(customer);
  }
}
