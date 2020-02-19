package com.jjo.awstests.domain;

import java.io.Serializable;
import com.jjo.awstests.model.BidEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {

  private static final long serialVersionUID = -2421560593845389952L;

  private MessageType type;
  private BidEntity object;
}
