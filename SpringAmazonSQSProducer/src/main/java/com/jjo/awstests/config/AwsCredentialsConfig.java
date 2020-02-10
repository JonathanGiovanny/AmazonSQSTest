package com.jjo.awstests.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.core.region.RegionProvider;
import org.springframework.cloud.aws.core.region.StaticRegionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;

@Configuration
public class AwsCredentialsConfig {

  @Value("${aws.profile:default}")
  private String profileName;

  @Bean
  @Profile(value = {"dev"})
  public AWSCredentialsProvider devCredentialsProvider() {
    AWSCredentialsProvider credProv = new ProfileCredentialsProvider(profileName);
    return credProv;
  }
  
  @Bean
  @Profile(value = {"prod"})
  public AWSCredentialsProvider prodCredentialsProvider() {
    return new EnvironmentVariableCredentialsProvider();
  }

  @Bean
  @Profile(value = {"dev"})
  public RegionProvider regionProvider() {
    return new StaticRegionProvider(Regions.US_EAST_1.getName());
  }
}
