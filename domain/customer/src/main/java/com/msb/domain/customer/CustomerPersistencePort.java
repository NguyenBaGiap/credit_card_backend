package com.msb.domain.customer;

import com.msb.domain.customer.models.Customer;
import com.msb.domain.shared.vo.CustomerId;
import com.msb.supports.domain.Repository;

import java.util.Optional;

public interface CustomerPersistencePort extends Repository<CustomerId, Customer> {
  Optional<Customer> findByMobileNumber(String mobileNumber);
}
