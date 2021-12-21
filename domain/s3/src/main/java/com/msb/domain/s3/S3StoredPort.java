package com.msb.domain.s3;

import java.io.File;

public interface S3StoredPort {
  Boolean uploadFile(String fileName, File file);
}
