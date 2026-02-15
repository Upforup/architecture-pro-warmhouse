package com.warmhouse.monitoring.config;

import com.warmhouse.monitoring.legacy.smart_home.ApiClient;
import com.warmhouse.monitoring.legacy.smart_home.api.SensorsApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public ApiClient apiClient(RestClient.Builder builder) {
        var apiClient = new ApiClient(builder.build());
        apiClient.setBasePath("http://app:8080");
        return apiClient;
    }

    @Bean
    public SensorsApi sensorsApi(ApiClient apiClient) {
        return new SensorsApi(apiClient);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH");
    }
}
