package com.msb.s3Stored;

import com.msb.domain.s3.S3StoredPort;
import com.msb.s3Stored.adapter.S3StoredAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3AdapterConfiguration {
  @Bean
  public S3StoredPort initialS3StoredPort() {
    return new S3StoredAdapter();
  }
}
