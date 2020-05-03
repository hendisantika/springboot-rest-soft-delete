package com.hendisantika.springbootrestsoftdelete.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-soft-delete
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/05/20
 * Time: 05.48
 */
@Configuration
public class JSONConfiguration {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public Module Hibernate5Module() {
        return new Hibernate5Module();
    }

    @Bean
    public Module JavaTimeModule() {
        return new JavaTimeModule();
    }

    @Bean
    public Module Jdk8Module() {
        return new Jdk8Module();
    }

    @Bean
    public Module ParameterNamesModule() {
        return new ParameterNamesModule();
    }

    @Bean
    public Module Jackson2HalModule() {
        return new Jackson2HalModule();
    }
}
