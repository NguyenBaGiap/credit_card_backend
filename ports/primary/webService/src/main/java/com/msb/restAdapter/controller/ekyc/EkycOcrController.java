package com.msb.restAdapter.controller.ekyc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping(value = "/api/private/ekyc")
public class EkycOcrController {

    @RequestMapping(value = "/ocr/pid/front", method = RequestMethod.POST)
    public String recognizeFrontSide() {
        return "api front pid";
    }

    @RequestMapping(value = "/ocr/pid/back", method = RequestMethod.POST)
    public String recognizeBackSide() {
        return "api back pid";
    }

    @RequestMapping(value = "/face/recognition", method = RequestMethod.POST)
    public String faceRecognize() {
        return "api face recognition";
    }
}
