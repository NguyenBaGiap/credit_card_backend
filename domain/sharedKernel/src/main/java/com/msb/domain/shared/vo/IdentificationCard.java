package com.msb.domain.shared.vo;

import com.msb.domain.shared.constant.Gender;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class IdentificationCard {
  String pid;
  LocalDateTime dateOfIssue;
  String placeOfIssue;
  LocalDateTime dob;
  Gender gender;

}
