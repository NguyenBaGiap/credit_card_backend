package com.msb.persistence.customer.entity;

import com.msb.domain.shared.constant.*;
import com.msb.persistence.adsense.entity.AdsenseEntity;
import com.msb.persistence.creditCard.entity.CreditCardEntity;
import com.msb.persistence.creditCardRating.entity.CreditCardRatingEntity;
import com.msb.persistence.creditCardRegistraction.entity.CreditCardRegistrationProfileEntity;
import com.msb.persistence.ekyc.entity.EkycProfileEntity;
import com.msb.supports.record.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
    name = "Customer",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"mobileNumber"})})
public class CustomerEntity extends AbstractEntity<Long> {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Long id;

  private String cif;

  @Column(name = "mobileNumber", length = 20)
  private String mobileNumber;

  private String email;
  private String fullName;
  private String profileCustomerType;

  @Enumerated(EnumType.STRING)
  private CustomerStatus customerStatus;

  @Enumerated(EnumType.STRING)
  private MarriageStatusType maritalStatus;

  @Enumerated(EnumType.STRING)
  private EducationLevelCode educationLevelCode;

  @Enumerated(EnumType.STRING)
  private CustomerType customerType;

  private String pid;
  private LocalDateTime pidIssuedDate;
  private String pidIssuedPlace;

  @Enumerated(EnumType.STRING)
  private Gender gender;
  private LocalDateTime dob;
  private String countryCode;
  private String residentialProvinceCode;
  private String residentialDistrictCode;
  private String residentialWardCode;
  private String residentialAddressDetails;
  private String currentProvinceCode;
  private String currentDistrictCode;
  private String currentWardCode;
  private String currentAddressDetails;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
  private Set<EkycProfileEntity> ekycProfiles = new HashSet<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
  private Set<CreditCardRegistrationProfileEntity> cardRegistrationProfiles = new HashSet<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
  private Set<AdsenseEntity> adsenseInformation = new HashSet<>();

  @OneToMany(mappedBy = "customer")
  private Set<CreditCardRatingEntity> creditCardRatings;

  @Override
  public Long getId() {
    return id;
  }
}
