package com.jjo.awstests.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.sqs.AmazonSQSAsync;

@EnableSqs
@Configuration
public class SQSConfig {

  @Bean("queueMessagingTemplate")
  public QueueMessagingTemplate customQueue(AmazonSQSAsync amazonSqs, @Value("${aws.sqs.producer}") String queueName) {
    QueueMessagingTemplate messageTemplate = new QueueMessagingTemplate(amazonSqs);
    messageTemplate.setDefaultDestinationName(queueName);
    return messageTemplate;
  }
}
