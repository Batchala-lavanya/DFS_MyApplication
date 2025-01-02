package com.demo.task.Client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.task.DTO.UserDto;
import com.demo.task.Service.ServiceImpl;

@FeignClient(name = "firstAppClient", url = "${first.app.url}")
public interface FirstAppByFeignClient {
	@GetMapping("/mytask/retriveUser/{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer id);

	//{http://localhost:8088/mytask}
}
