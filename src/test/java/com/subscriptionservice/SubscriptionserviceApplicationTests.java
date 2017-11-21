package com.subscriptionservice;

import com.subscriptionservice.backend.service.EmailService;
import com.subscriptionservice.backend.service.I18nService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;


public class SubscriptionserviceApplicationTests {

	@Autowired
    private I18nService i18nService;

	@Test
	public void testMessageByLocaleService() throws IOException{
		String expectedresult ="Bootstrap starter template";
		String messageId ="index.main.callout";
		String actual=i18nService.getMessage(messageId);
		Assert.assertEquals("The expected and actual strings dont match",expectedresult,actual);
	}

}
