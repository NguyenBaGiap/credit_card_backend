package com.msb.trustingSocial.adapter;

import com.msb.domain.ekyc.EkycTrustingSocialServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

public class EkycTrustingSocialServiceAdapter implements EkycTrustingSocialServicePort {

    @Autowired
    @Qualifier( value = "trustingSocialRestTemplate")
    private  RestTemplate restTemplate;


    public String uploadImages() {
//        ResponseEntity<String> x = restTemplate.exchange("/x",
//                HttpMethod.POST,
//                null,
//                String.class);

        return null;
    }
}
