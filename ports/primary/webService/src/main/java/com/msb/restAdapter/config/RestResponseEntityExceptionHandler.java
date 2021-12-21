package com.msb.restAdapter.config;

import com.msb.supports.dto.ResponseDTO;
import com.msb.supports.exceptions.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

  @ExceptionHandler(value = {BusinessException.class})
  protected ResponseEntity<Object> handleRestBusinessException(BusinessException exception) {
    Map<String, String> errors = new HashMap<>();
    errors.put("message", exception.getLocalizedMessage());
    errors.put("code", exception.getCode());
    ResponseDTO<Object> responseBuilder =
        ResponseDTO.builder().timestamp(LocalDateTime.now()).errors(errors).build();
    return new ResponseEntity<>(responseBuilder, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<Object> handleNoHandlerFound(NoHandlerFoundException e) {
    HashMap<String, String> errors = new HashMap<>();
    errors.put("message", e.getLocalizedMessage());
    errors.put("code", HttpStatus.NOT_FOUND.name());
    ResponseDTO<Object> responseBuilder =
        ResponseDTO.builder().timestamp(LocalDateTime.now()).errors(errors).build();
    return new ResponseEntity<>(responseBuilder, HttpStatus.NOT_FOUND);
  }
}
