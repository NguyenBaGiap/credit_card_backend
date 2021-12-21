package com.msb.persistence.customer.mapper;

import com.msb.domain.customer.models.Customer;
import com.msb.persistence.customer.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  Customer entityToDomain(CustomerEntity entity);

  CustomerEntity domainToEntity(Customer customer);
}
