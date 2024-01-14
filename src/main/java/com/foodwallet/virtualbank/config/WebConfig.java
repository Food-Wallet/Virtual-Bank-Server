package com.foodwallet.virtualbank.config;

import com.foodwallet.virtualbank.interceptor.LoggingInterceptor;
import com.foodwallet.virtualbank.interceptor.query.ApiQueryCounter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig 설정
 *
 * @author 임우택
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ApiQueryCounter apiQueryCounter;

    public WebConfig(ApiQueryCounter apiQueryCounter) {
        this.apiQueryCounter = apiQueryCounter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor(apiQueryCounter));
    }
}
