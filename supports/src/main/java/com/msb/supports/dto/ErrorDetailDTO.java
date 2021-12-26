package com.msb.supports.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ErrorDetailDTO {
    private String code;
    private String message;
    private Map<String, String> details;

}
