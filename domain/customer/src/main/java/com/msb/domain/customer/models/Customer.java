package com.msb.domain.customer.models;

import com.msb.domain.shared.constant.CustomerStatus;
import com.msb.domain.shared.constant.CustomerType;
import com.msb.domain.shared.constant.EducationLevelCode;
import com.msb.domain.shared.constant.MarriageStatusType;
import com.msb.domain.shared.vo.Address;
import com.msb.domain.shared.vo.CustomerId;
import com.msb.domain.shared.vo.IdentificationCard;
import com.msb.supports.domain.AggregateRoot;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class Customer extends AggregateRoot<CustomerId> {
  @Getter(AccessLevel.NONE)
  private CustomerId customerId;

  private String fullName;
  private String mobileNumber;
  private String email;
  private IdentificationCard identificationCard;
  private String cif;
  private CustomerStatus customerStatus;
  private MarriageStatusType maritalStatus;
  private EducationLevelCode educationLevelCode;
  private CustomerType customerType;
  private String profileCustomerType;
  private Address currentAddress;
  private Address residentAddress;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @Override
  public CustomerId getIdentifier() {
    return customerId;
  }
}
