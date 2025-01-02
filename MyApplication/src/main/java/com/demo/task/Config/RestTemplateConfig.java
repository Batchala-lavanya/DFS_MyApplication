package com.demo.task.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.demo.task.DTO.UserDto;

@Component
public class RestTemplateConfig {
	
	@Autowired
    private RestTemplate restTemplate;
	
	public ResponseEntity<UserDto> getUserById(Integer id) {
        String url = "http://localhost:8088/mytask/retriveUser/" + id;
        //try {
            return restTemplate.getForEntity(url, UserDto.class);
        //} catch (HttpStatusCodeException e) {
           // return ResponseEntity.status(e.getStatusCode()).build();
        //}
    }

}
