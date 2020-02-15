package com.jjo.awstests.services;

import com.jjo.awstests.domain.Message;

public interface SQSService {

  void convertAndSend(Message message);

}
