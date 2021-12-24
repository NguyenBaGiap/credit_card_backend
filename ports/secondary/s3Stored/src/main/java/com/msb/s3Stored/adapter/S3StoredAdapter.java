package com.msb.s3Stored.adapter;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.msb.domain.s3.S3StoredPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;

@Slf4j
public class S3StoredAdapter implements S3StoredPort {

  @Value("${s3.credential.accessKey}")
  private String accessKey;

  @Value("${s3.credential.secretKey}")
  private String secretKey;

  public final AmazonS3 s3clientBuilder() {
    AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
    return AmazonS3ClientBuilder.standard()
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .withRegion(Regions.AP_NORTHEAST_2)
        .build();
  }

  @Override
  public Boolean uploadFile(String fileName, File file) {
    log.info("file upload: {}", fileName);
    return Boolean.FALSE;
  }
}
