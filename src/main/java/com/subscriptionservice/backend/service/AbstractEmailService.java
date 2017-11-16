package com.subscriptionservice.backend.service;

import com.subscriptionservice.web.domain.frontend.FeedbackPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

public abstract class AbstractEmailService implements EmailService {

    @Value("@{default.to.address}")
    private String defaultToAddress ;

   protected SimpleMailMessage preparedSimpleMailMessageFromFeedbackPojo(FeedbackPojo feedback){
       SimpleMailMessage message = new SimpleMailMessage();
       message.setTo(defaultToAddress);
       message.setFrom(feedback.getEmail());
       message.setSubject("[Subscriber]: Feedback Received from"+ feedback.getFirstName()+" "+feedback.getLastName()+"!");
       message.setText(feedback.getFeedback());

       return message;
   }

    @Override
    public void sendFeedbackEmail(FeedbackPojo feedbackPojo) {
       sendGenericEmailMessage(preparedSimpleMailMessageFromFeedbackPojo(feedbackPojo));
    }

}
