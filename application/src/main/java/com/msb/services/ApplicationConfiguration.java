package com.msb.services;

import com.msb.domain.customer.CustomerPersistencePort;
import com.msb.services.adapter.CustomerServiceAdapter;
import com.msb.services.api.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
  @Bean
  public CustomerService getCustomerService(CustomerPersistencePort customerPersistencePort) {
    return new CustomerServiceAdapter(customerPersistencePort);
  }
}
