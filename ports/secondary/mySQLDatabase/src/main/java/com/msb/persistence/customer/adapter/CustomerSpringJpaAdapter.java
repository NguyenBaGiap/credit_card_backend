package com.msb.persistence.customer.adapter;

import com.msb.domain.customer.CustomerPersistencePort;
import com.msb.domain.customer.models.Customer;
import com.msb.domain.shared.vo.CustomerId;
import com.msb.persistence.customer.entity.CustomerEntity;
import com.msb.persistence.customer.mapper.CustomerMapper;
import com.msb.persistence.customer.repository.CustomerRepository;
import com.msb.supports.exceptions.BusinessException;
import com.msb.supports.message.MessageUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.function.Function;

@Slf4j
public class CustomerSpringJpaAdapter implements CustomerPersistencePort {
  final CustomerRepository customerRepository;
  final CustomerMapper customerMapper;

  public CustomerSpringJpaAdapter(
      CustomerRepository customerRepository, CustomerMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  @Override
  public Optional<Customer> findByMobileNumber(String mobileNumber) {
    return customerRepository.findByMobileNumber(mobileNumber).map(customerMapper::fromEntity);
  }

  @Override
  public Optional<Customer> findByID(CustomerId customerId) {
    return customerRepository.findById(customerId.getValue()).map(customerMapper::fromEntity);
  }

  @Override
  public Customer save(Customer customer) throws BusinessException {
    Function<Customer, CustomerEntity> m1 = customerMapper::fromDomain;
    Function<CustomerEntity, Customer> m2 = customerMapper::fromEntity;
    Function<CustomerEntity, CustomerEntity> save = customerRepository::save;
    Customer test = customerRepository.findById(10L).map(m2).orElse(null);
    assert test != null;
    log.info(test.toString());
    return Optional.ofNullable(customer)
        .map(m1.andThen(save).andThen(m2))
        .orElseThrow(() -> new BusinessException(MessageUtil.Customer.CUSTOMER_REGISTER_ERROR));
  }
}
