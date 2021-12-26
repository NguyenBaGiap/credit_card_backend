package com.msb.supports.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseDTO<T> {
  private LocalDateTime timestamp;
  private ErrorDetailDTO errors;
  private T data;
}
