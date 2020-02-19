package com.jjo.awstests.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.core.env.ResourceIdResolver;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.AwsRegionProvider;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@EnableSqs
@Configuration
@AllArgsConstructor
public class SQSConfig {

  private @NonNull AWSCredentialsProvider awsCredentialsProvider;
  private @NonNull AwsRegionProvider awsRegionProvider;
  private @NonNull ObjectMapper objectMapper;

  private AmazonSQSAsync amazonSQSAsync() {
    return AmazonSQSAsyncClientBuilder.standard()
        .withCredentials(awsCredentialsProvider)
        .withRegion(awsRegionProvider.getRegion())
        .build();
  }

  @Bean(name = {"queueMessagingTemplate", "bidQueueMessaging"})
  public QueueMessagingTemplate customQueue(@Value("${aws.sqs.queue-bid}") String queueName) {
    QueueMessagingTemplate messageTemplate = new QueueMessagingTemplate(amazonSQSAsync(), (ResourceIdResolver) null, messageConverter());
    messageTemplate.setDefaultDestinationName(queueName);
    return messageTemplate;
  }

  private MappingJackson2MessageConverter messageConverter() {
    MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
    messageConverter.setStrictContentTypeMatch(false);
    messageConverter.setObjectMapper(objectMapper);
    messageConverter.setSerializedPayloadClass(String.class);
    return messageConverter;
  }
}
