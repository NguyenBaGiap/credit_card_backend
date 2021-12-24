package com.msb.supports.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;

public class JsonUtil {
  @Deprecated
  protected JsonUtil() {
    super();
  }

  private static final ObjectMapper JSON_MAPPER =
      new ObjectMapper()
          .registerModule(new AfterburnerModule())
          .registerModule(
              new SimpleModule()
                  .addSerializer(
                      LocalDateTime.class,
                      new LocalDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME))
                  .addDeserializer(
                      LocalDateTime.class,
                      new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME))
                  .addSerializer(
                      LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ISO_DATE_TIME))
                  .addDeserializer(
                      LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ISO_DATE_TIME)))
          .configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

  private static final ObjectMapper PRETTY_JSON_MAPPER =
      new ObjectMapper()
          .registerModule(new AfterburnerModule())
          .registerModule(
              new SimpleModule()
                  .addSerializer(
                      LocalDateTime.class,
                      new LocalDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME))
                  .addDeserializer(
                      LocalDateTime.class,
                      new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME))
                  .addSerializer(
                      LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ISO_DATE_TIME))
                  .addDeserializer(
                      LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ISO_DATE_TIME)))
          .configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
          .enable(INDENT_OUTPUT);

  private static final ObjectWriter JSON_WRITER = JSON_MAPPER.writer();
  private static final ObjectWriter PRETTY_JSON_WRITER = PRETTY_JSON_MAPPER.writer();

  public static <T> String toPrettyJson(final T object) throws JsonProcessingException {
    return PRETTY_JSON_WRITER.writeValueAsString(object);
  }

  public static <T> String toJson(final T object) throws JsonProcessingException {
    return JSON_WRITER.writeValueAsString(object);
  }

  public static <T> T fromJson(final String input, final Class<T> returnType) throws IOException {
    return PRETTY_JSON_MAPPER.readerFor(returnType).readValue(input);
  }
}
