package com.msb.restAdapter.models.request;

import com.msb.supports.message.MessageUtil;
import com.msb.supports.util.JsonUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CustomerLoginRequest {
    @NotBlank(message = MessageUtil.Validation.MOBILE_NUMBER_VALID)
    private String mobileNumber;
    private String utmSource;
    private String utmPartner;

    @Override
    public String toString() {
        try {
            return JsonUtil.toPrettyJson(this);
        } catch (Exception exception) {
            return super.toString();
        }
    }
}
