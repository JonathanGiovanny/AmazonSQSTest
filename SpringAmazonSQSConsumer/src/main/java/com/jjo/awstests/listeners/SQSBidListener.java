package com.jjo.awstests.listeners;

import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjo.awstests.domain.Message;
import com.jjo.awstests.domain.MessageType;
import com.jjo.awstests.model.BidEntity;
import com.jjo.awstests.services.BidService;
import com.jjo.awstests.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class SQSBidListener {

  private @NonNull BidService bidService;
  private @NonNull ObjectMapper objectMapper;

  @SqsListener(value = {"${aws.sqs.queue-bid}"}, deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
  private void readBidQueue(String messageJson) {
    log.info("Message read from queue: {}",
             messageJson);
    Message message = Utils.fromJson(objectMapper, messageJson);
    if (MessageType.BID.equals(message.getType())) {
      log.info("Persisiting entity");
      bidService.saveBid(parseMessage(message.getObject()));
    }
  }

  private BidEntity parseMessage(Object obj) {
    return (BidEntity) obj;
  }
}
