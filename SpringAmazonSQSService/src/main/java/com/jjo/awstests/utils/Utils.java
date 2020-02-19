package com.jjo.awstests.utils;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjo.awstests.domain.Message;
import com.jjo.awstests.exception.Errors;
import com.jjo.awstests.exception.HException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class Utils {

  /**
   * Validates whenever a value is null or empty for a String
   */
  public static String isNotNullOr(String dto, String entity) {
    return Optional.ofNullable(dto).filter(s -> !s.isEmpty()).orElse(entity);
  }

  /**
   * Validates whenever a value is null or empty for a String
   */
  public static <T> Stream<T> isNotNullOrEmpty(Collection<T> coll) {
    return Optional.ofNullable(coll).map(c -> c.stream()).orElse(Stream.empty()).filter(Objects::nonNull);
  }

  public static RuntimeException throwNotExistingElement(List<Object> fields) {
    return new HException(Errors.NO_DATA, fields.toString());
  }

  public static String toJson(ObjectMapper objectMapper, Message message) {
    try {
      return objectMapper.writeValueAsString(message);
    } catch (JsonProcessingException e) {
      log.error(e.getMessage());
      throw new HException(Errors.JSON_FORMAT, e);
    }
  }

  public static Message fromJson(ObjectMapper objectMapper, String json) {
    try {
      return objectMapper.readValue(json, Message.class);
    } catch (JsonProcessingException e) {
      log.error(e.getMessage());
      throw new HException(Errors.JSON_FORMAT, e);
    }
  }
}
