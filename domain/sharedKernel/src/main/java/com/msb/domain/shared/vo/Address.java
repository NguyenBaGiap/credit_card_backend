package com.msb.domain.shared.vo;

import lombok.Value;

@Value
public class Address {
  String provinceCode;
  String districtCode;
  String wardCode;
  String details;
}
