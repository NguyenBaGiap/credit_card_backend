package com.msb.persistence;

import com.msb.domain.customer.CustomerPersistencePort;
import com.msb.persistence.customer.adapter.CustomerSpringJpaAdapter;
import com.msb.persistence.customer.mapper.CustomerMapper;
import com.msb.persistence.customer.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDataJpaAdapterConfiguration {
  @Bean
  public CustomerPersistencePort initialCustomerPersistencePort(
      CustomerRepository customerRepository, CustomerMapper customerMapper) {
    return new CustomerSpringJpaAdapter(customerRepository, customerMapper);
  }
}
