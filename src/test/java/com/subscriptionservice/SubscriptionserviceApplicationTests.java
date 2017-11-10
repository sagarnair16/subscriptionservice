package com.subscriptionservice;

import com.subscriptionservice.web.i18n.I18nService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionserviceApplicationTests {

	@Autowired
	I18nService i18nService;

	@Test
	public void testMessageByLocaleService() throws IOException{
		String expectedresult ="Bootstrap starter template";
		String messageId ="index.main.callout";
		String actual=i18nService.getMessage(messageId);
		Assert.assertEquals("The expected and actual strings dont match",expectedresult,actual);
	}

}
