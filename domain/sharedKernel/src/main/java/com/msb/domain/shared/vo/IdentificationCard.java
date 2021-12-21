package com.msb.domain.shared.vo;

import com.msb.domain.shared.constant.Gender;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class IdentificationCard {
  String legalId;
  String dateOfIssue;
  String placeOfIssue;
  LocalDateTime birthday;
  Gender gender;
}
