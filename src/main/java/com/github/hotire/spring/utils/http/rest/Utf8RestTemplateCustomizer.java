package com.github.hotire.spring.utils.http.rest;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

public class Utf8RestTemplateCustomizer implements RestTemplateCustomizer {
    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.getMessageConverters()
                    .stream()
                    .filter(converter -> converter instanceof AbstractHttpMessageConverter)
                    .map(AbstractHttpMessageConverter.class::cast)
                    .forEach(converter -> converter.setDefaultCharset(StandardCharsets.UTF_8));
    }
}
