package com.msb.supports.exceptions;

import com.msb.supports.message.MessageUtil;

import java.util.Optional;

public class BusinessException extends Exception {
  private String code;
  private String message;

  public BusinessException(String code) {
    this.code = code;
    message = Optional.ofNullable(MessageUtil.get(code)).orElse("Internal server error");
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
