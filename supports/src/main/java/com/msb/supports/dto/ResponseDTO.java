package com.msb.supports.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
public class ResponseDTO<T> {
  private LocalDateTime timestamp;
  private Map<String, String> errors;
  private T data;
}
