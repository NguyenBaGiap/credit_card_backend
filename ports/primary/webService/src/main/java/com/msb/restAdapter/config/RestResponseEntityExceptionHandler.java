package com.msb.restAdapter.config;

import com.msb.supports.dto.ErrorDetailDTO;
import com.msb.supports.dto.ResponseDTO;
import com.msb.supports.exceptions.BusinessException;
import com.msb.supports.message.MessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

  @ExceptionHandler(value = {BusinessException.class})
  protected ResponseEntity<Object> handleRestException(BusinessException exception) {
    ErrorDetailDTO errors =
        ErrorDetailDTO.builder()
            .code(exception.getCode())
            .message(exception.getLocalizedMessage())
            .build();
    ResponseDTO<Object> responseBuilder =
        ResponseDTO.builder().timestamp(LocalDateTime.now()).errors(errors).build();
    return new ResponseEntity<>(responseBuilder, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<Object> handleNoHandlerFound(NoHandlerFoundException e) {
    ErrorDetailDTO errors =
        ErrorDetailDTO.builder()
            .code(HttpStatus.NOT_FOUND.name())
            .message(e.getLocalizedMessage())
            .build();
    ResponseDTO<Object> responseBuilder =
        ResponseDTO.builder().timestamp(LocalDateTime.now()).errors(errors).build();
    return new ResponseEntity<>(responseBuilder, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<Object> handleMethodArgumentException(
      MethodArgumentNotValidException exception) {
    Map<String, String> details =
        exception.getBindingResult().getFieldErrors().stream()
            .collect(
                Collectors.toMap(
                    FieldError::getField,
                    fieldError -> MessageUtil.get(fieldError.getDefaultMessage())));
    // Global errors
    details.putAll(
        exception.getBindingResult().getGlobalErrors().stream()
            .collect(
                Collectors.toMap(
                    ObjectError::getObjectName,
                    objectError -> MessageUtil.get(objectError.getDefaultMessage()))));
    ErrorDetailDTO errors =
        ErrorDetailDTO.builder()
            .code(MessageUtil.Validation.METHOD_ARGUMENT_VALID)
            .message(MessageUtil.get(MessageUtil.Validation.METHOD_ARGUMENT_VALID))
            .details(details)
            .build();
    ResponseDTO<Object> responseBuilder =
        ResponseDTO.builder().timestamp(LocalDateTime.now()).errors(errors).build();
    return new ResponseEntity<>(responseBuilder, HttpStatus.BAD_REQUEST);
  }
}
