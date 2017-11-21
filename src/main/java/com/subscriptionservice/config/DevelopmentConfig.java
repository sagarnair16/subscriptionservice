package com.subscriptionservice.config;


import com.subscriptionservice.backend.service.EmailService;
import com.subscriptionservice.backend.service.MockEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ConfigurationProperties(prefix = "dev")
@PropertySource("file:///${user.home}/subscription/application-dev.properties")
public class DevelopmentConfig {

    @Bean
    public  EmailService emailService(){
        return new MockEmailService();
    }

}
