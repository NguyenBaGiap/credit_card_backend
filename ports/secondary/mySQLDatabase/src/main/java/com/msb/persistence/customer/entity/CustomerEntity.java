package com.msb.persistence.customer.entity;

import com.msb.domain.shared.constant.*;
import com.msb.supports.record.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Customer", uniqueConstraints = { @UniqueConstraint(columnNames = { "mobile_number" }) })
public class CustomerEntity extends AbstractEntity<Long> {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "cif")
  private String cif;

  @Column(name = "mobile_number", length = 20)
  private String mobileNumber;

  @Column(name = "email")
  private String email;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "profile_customer_type")
  private String profileCustomerType;

  @Enumerated(EnumType.STRING)
  @Column(name = "customer_status")
  private CustomerStatus customerStatus;

  @Enumerated(EnumType.STRING)
  @Column(name = "marriage_status")
  private MarriageStatusType maritalStatus;

  @Enumerated(EnumType.STRING)
  @Column(name = "edu_degree_code")
  private EducationLevelCode educationLevelCode;

  @Enumerated(EnumType.STRING)
  @Column(name = "customer_type")
  private CustomerType customerType;

  @Column(name = "pid")
  private String pid;

  @Column(name = "pid_issued_date")
  private LocalDateTime pidIssuedDate;

  @Column(name = "pid_issued_place")
  private String pidIssuedPlace;

  @Enumerated(EnumType.STRING)
  @Column(name = "gender")
  private Gender gender;

  @Column(name = "dob")
  private LocalDateTime dob;

  @Column(name = "country_code")
  private String countryCode;

  @Column(name = "residential_province_code")
  private String residentialProvinceCode;

  @Column(name = "residential_district_code")
  private String residentialDistrictCode;

  @Column(name = "residential_ward_code")
  private String residentialWardCode;

  @Column(name = "residential_address_details")
  private String residentialAddressDetails;

  @Column(name = "current_province_code")
  private String currentProvinceCode;

  @Column(name = "current_district_code")
  private String currentDistrictCode;

  @Column(name = "current_ward_code")
  private String currentWardCode;

  @Column(name = "current_address_details")
  private String currentAddressDetails;

  @Column(name = "created_at", columnDefinition = "timestamp")
  protected LocalDateTime createdAt;

  @Column(name = "updated_at", columnDefinition = "timestamp")
  protected LocalDateTime updatedAt;

  @Override
  public Long getId() {
    return id;
  }
}
