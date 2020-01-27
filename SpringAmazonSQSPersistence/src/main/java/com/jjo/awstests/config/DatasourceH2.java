package com.jjo.awstests.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"com.jjo.awstests.repositories"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.jjo.awstests.repositories"})
public class DatasourceH2 {

  @Value(value = "${spring.datasource.driver-class-name}")
  private String driverClassName;

  @Value(value = "${spring.datasource.jdbc-url}")
  private String url;

  @Value(value = "${spring.datasource.username}")
  private String username;

  @Value(value = "${spring.datasource.password}")
  private String password;

  @Bean
  public HikariDataSource dataSource() {
    return DataSourceBuilder.create()
        .driverClassName(driverClassName)
        .url(url)
        .username(username)
        .password(password)
        .type(HikariDataSource.class).build();
  }
}
 