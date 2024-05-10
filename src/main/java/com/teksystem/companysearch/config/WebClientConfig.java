package com.teksystem.companysearch.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    public final WebClient webClient;

    @Autowired
    public WebClientConfig(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://exercise.trunarrative.cloud/TruProxyAPI/rest/Companies/v1/").build();
    }
}
