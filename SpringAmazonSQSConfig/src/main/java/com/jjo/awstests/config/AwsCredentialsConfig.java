package com.jjo.awstests.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.AwsEnvVarOverrideRegionProvider;
import com.amazonaws.regions.AwsProfileRegionProvider;
import com.amazonaws.regions.AwsRegionProvider;

@Configuration
public class AwsCredentialsConfig {

  @Value("${aws.profile:default}")
  private String profileName;

  private static final String PROFILE = "profile ";
  
  @Bean
  @Primary
  @Profile(value = {"dev"})
  public AWSCredentialsProvider devCredentialsProvider() {
    AWSCredentialsProvider credProv = new ProfileCredentialsProvider(profileName);
    return credProv;
  }

  @Bean
  @Primary
  @Profile(value = {"prod"})
  public AWSCredentialsProvider prodCredentialsProvider() {
    return new EnvironmentVariableCredentialsProvider();
  }

  @Bean
  @Profile(value = {"dev"})
  public AwsRegionProvider devRegionProvider() {
    return new AwsProfileRegionProvider(PROFILE + profileName);
  }

  @Bean
  @Profile(value = {"prod"})
  public AwsRegionProvider prodRegionProvider() {
    return new AwsEnvVarOverrideRegionProvider();
  }
}
