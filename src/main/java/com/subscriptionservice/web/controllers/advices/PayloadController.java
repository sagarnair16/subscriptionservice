package com.subscriptionservice.web.controllers.advices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PayloadController {

    private static final String PAYLOAD_VIEW_NAME= "payload/payload";

    @RequestMapping(value = "/payload", method = RequestMethod.GET)
    public String payload(){
        return PAYLOAD_VIEW_NAME;
    }
}
