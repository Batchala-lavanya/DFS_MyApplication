package com.demo.task.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateclass {
	@Bean
	 public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
