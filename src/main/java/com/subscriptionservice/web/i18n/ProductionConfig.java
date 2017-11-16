package com.subscriptionservice.web.i18n;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/web-skeleton/application-prod.properties")
public class ProductionConfig {
}
