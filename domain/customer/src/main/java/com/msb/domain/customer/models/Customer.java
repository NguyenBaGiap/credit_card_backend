package com.msb.domain.customer.models;

import com.msb.domain.shared.constant.CustomerStatus;
import com.msb.domain.shared.constant.CustomerType;
import com.msb.domain.shared.constant.EducationLevelCode;
import com.msb.domain.shared.constant.MarriageStatusType;
import com.msb.domain.shared.vo.Address;
import com.msb.domain.shared.vo.CustomerId;
import com.msb.domain.shared.vo.IdentificationCard;
import com.msb.supports.domain.AggregateRoot;
import com.msb.supports.util.JsonUtil;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class Customer extends AggregateRoot<CustomerId> {
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
  public String toString() {
    try {
      return JsonUtil.toPrettyJson(this);
    } catch (Exception exception) {
      return super.toString();
    }
  }
}
