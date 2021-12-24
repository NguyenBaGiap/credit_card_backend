package com.msb.trustingSocial.template;

import com.msb.supports.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Configuration
@EnableAsync
public class RestTemplateConfiguration {

  @Value("${eKYC.trustingSocial.accessKey}")
  private String accessKey;

  @Value("${eKYC.trustingSocial.secretKey}")
  private String secretKey;

  @Bean(name = "trustingSocialRestTemplate")
  public RestTemplate trustingSocialRestTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    interceptors.add(new HeaderRequestInterceptor(accessKey, secretKey));
    restTemplate.setInterceptors(interceptors);
    return restTemplate;
  }

  public static class HeaderRequestInterceptor implements ClientHttpRequestInterceptor {
    private static final String BREAK_LINE_PATTERN = "\n";
    private static final String ACCESS_TOKEN_PREFIX = "TV ";
    private static final String ALGORITHM_HASH = "HmacSHA256";
    private static final String SEPARATED_CHARACTER = ":";
    private static final String HEADER_TIMESTAMP = "X-TV-Timestamp";

    private final String accessKey;
    private final String secretKey;

    public HeaderRequestInterceptor(String accessKey, String secretKey) {
      this.accessKey = accessKey;
      this.secretKey = secretKey;
    }

    private String initialAccessToken(HttpRequest request, String timestamp) {
      String requestMethod = request.getMethodValue();
      String requestPath = request.getURI().getPath();
      String sign =
          requestMethod
              .concat(BREAK_LINE_PATTERN)
              .concat(requestPath)
              .concat(BREAK_LINE_PATTERN)
              .concat(timestamp);
      try {
        Mac sha256_HMAC = Mac.getInstance(ALGORITHM_HASH);
        SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM_HASH);
        sha256_HMAC.init(secret_key);
        String signature =
            Base64.encodeBase64String(sha256_HMAC.doFinal(sign.getBytes(StandardCharsets.UTF_8)));

        return ACCESS_TOKEN_PREFIX.concat(accessKey).concat(SEPARATED_CHARACTER).concat(signature);

      } catch (Exception exception) {
        log.error(
            "Create access token trusting social errors: {}", exception.getLocalizedMessage());
        return null;
      }
    }

    @Override
    public ClientHttpResponse intercept(
        HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
      String timestamp = DateUtil.convertToRFC3339(new Date());
      String accessToken = initialAccessToken(request, timestamp);
      request.getHeaders().set(HEADER_TIMESTAMP, timestamp);
      request.getHeaders().set(HttpHeaders.AUTHORIZATION, accessToken);
      return execution.execute(request, body);
    }
  }
}
