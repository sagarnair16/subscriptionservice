package com.subscriptionservice.web.controllers;

import com.subscriptionservice.backend.service.EmailService;
import com.subscriptionservice.web.domain.frontend.FeedbackPojo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.util.locale.provider.LocaleServiceProviderPool;

import java.util.logging.Logger;

@Controller
public class ContactController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ContactController.class);
    public static final String FEEDBACK_MODEL_KEY="feedback";
    private static final String CONTACT_US_VIEW_NAME="contact/contact";

    @Autowired
    private EmailService emailService;


    @RequestMapping(value = "/contact",method = RequestMethod.GET)
    public String getContact(ModelMap model){
        FeedbackPojo feedbackPojo = new FeedbackPojo();
        model.addAttribute(ContactController.FEEDBACK_MODEL_KEY,feedbackPojo);
        return ContactController.CONTACT_US_VIEW_NAME;
    }

    @RequestMapping(value = "/contact",method = RequestMethod.POST)
    public String postContact(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedbackPojo feedback){
        log.debug("Feedback content {}",feedback);
        emailService.sendFeedbackEmail(feedback);
        return ContactController.CONTACT_US_VIEW_NAME;
    }
}
