package com.example.demo.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "demo")
public class DemoConfig {
    
    private Mail mail;

    @Getter
    @Setter
    @ConfigurationProperties(prefix = "mail")
    public static class Mail {
    private String mailAddr;        
    }
}
