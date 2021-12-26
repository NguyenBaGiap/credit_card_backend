package com.msb.supports.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;

import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ResourceBundle;

@Slf4j
public class MessageUtil {
  private static final String BUNDLE_NAME = "message/message";
  private static final ResourceBundle resourceBundle =
      ResourceBundle.getBundle(BUNDLE_NAME, LocaleContextHolder.getLocale());

  private MessageUtil() {}

  public static String get(final String key, final Object... arguments) {
    try {
      String value = resourceBundle.getString(key);
      value = new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
      return arguments == null || arguments.length == 0
          ? value
          : MessageFormat.format(value, arguments);
    } catch (Exception e) {
      log.error("unable to find resource for key: " + key);
      return key;
    }
  }

  public static class Auth {
    public static final String AUTH_ACCESS_DENIED = "auth.access_denied";
  }
  public static class Validation {
    public static final String METHOD_ARGUMENT_VALID = "validation.method.argument.error"; // MethodArgumentNotValidException
    public static final String MOBILE_NUMBER_VALID = "validation.mobile_number.error";
  }

  public static class Customer {
    public static final String CUSTOMER_REGISTER_ERROR = "customer.register.error";
    public static final String CUSTOMER_NOT_FOUND = "customer.not_found";
  }
}
