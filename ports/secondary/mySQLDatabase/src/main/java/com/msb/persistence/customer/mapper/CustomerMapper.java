package com.msb.persistence.customer.mapper;

import com.msb.domain.customer.models.Customer;
import com.msb.domain.shared.vo.Address;
import com.msb.domain.shared.vo.CustomerId;
import com.msb.persistence.customer.entity.CustomerEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

  @Mappings({
    @Mapping(source = "id", target = "customerId.value"),
    @Mapping(source = "currentProvinceCode", target = "currentAddress.provinceCode"),
    @Mapping(source = "currentDistrictCode", target = "currentAddress.districtCode"),
    @Mapping(source = "currentWardCode", target = "currentAddress.wardCode"),
    @Mapping(source = "currentAddressDetails", target = "currentAddress.details"),
    @Mapping(source = "residentialProvinceCode", target = "residentialAddress.provinceCode"),
    @Mapping(source = "residentialDistrictCode", target = "residentialAddress.districtCode"),
    @Mapping(source = "residentialWardCode", target = "residentialAddress.wardCode"),
    @Mapping(source = "residentialAddressDetails", target = "residentialAddress.details"),
  })
  Customer fromEntity(CustomerEntity entity);

  @Mappings({
    @Mapping(source = "customer.customerId.value", target = "id"),
    @Mapping(source = "customer.identificationCard.pid", target = "pid"),
    @Mapping(source = "customer.identificationCard.dateOfIssue", target = "pidIssuedDate"),
    @Mapping(source = "customer.identificationCard.placeOfIssue", target = "pidIssuedPlace"),
    @Mapping(source = "customer.identificationCard.gender", target = "gender"),
    @Mapping(source = "customer.identificationCard.dob", target = "dob"),
    @Mapping(source = "customer.currentAddress.provinceCode", target = "currentProvinceCode"),
    @Mapping(source = "customer.currentAddress.districtCode", target = "currentDistrictCode"),
    @Mapping(source = "customer.currentAddress.wardCode", target = "currentWardCode"),
    @Mapping(source = "customer.currentAddress.details", target = "currentAddressDetails"),
    @Mapping(
        source = "customer.residentialAddress.provinceCode",
        target = "residentialProvinceCode"),
    @Mapping(
        source = "customer.residentialAddress.districtCode",
        target = "residentialDistrictCode"),
    @Mapping(source = "customer.residentialAddress.wardCode", target = "residentialWardCode"),
    @Mapping(source = "customer.residentialAddress.details", target = "residentialAddressDetails"),
  })
  CustomerEntity fromDomain(Customer customer);

}
