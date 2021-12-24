package com.msb.trustingSocial;

import com.msb.domain.ekyc.EkycTrustingSocialServicePort;
import com.msb.trustingSocial.adapter.EkycTrustingSocialServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrustingSocialAdapterConfiguration {
  @Bean
  public EkycTrustingSocialServicePort initialEkycTrustingSocialServicePort() {
    return new EkycTrustingSocialServiceAdapter();
  }
}
