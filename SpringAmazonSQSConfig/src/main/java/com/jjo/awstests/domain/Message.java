package com.jjo.awstests.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Message implements Serializable {

  private static final long serialVersionUID = -2421560593845389952L;

  private MessageType type;
  private Object object;
}
