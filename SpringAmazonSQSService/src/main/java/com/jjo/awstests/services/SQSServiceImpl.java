package com.jjo.awstests.services;

import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjo.awstests.domain.Message;
import com.jjo.awstests.utils.Utils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SQSServiceImpl implements SQSService {

  private @NonNull QueueMessagingTemplate queueMessagingTemplate;
  private @NonNull ObjectMapper objectMapper;

  @Override
  public void convertAndSend(Message message) {
    String jsonEntity = Utils.toJson(objectMapper,
                                     message);
    log.info("Sending message to SQS: {}", jsonEntity);
    queueMessagingTemplate.convertAndSend(jsonEntity);
  }
}
