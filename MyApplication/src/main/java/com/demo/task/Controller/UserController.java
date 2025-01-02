package com.demo.task.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.task.BO.BoInterface;
import com.demo.task.Client.FirstAppByFeignClient;
import com.demo.task.Config.RestTemplateConfig;
import com.demo.task.DTO.UserDto;
import com.demo.task.Service.ServiceInterface;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	 	
	    @Autowired
	    private ServiceInterface serviceObj;
	    
	    @GetMapping("/getUserByIdRestTemplate/{id}")
	    @CircuitBreaker(name = "getUserByIdCB", fallbackMethod = "getUserFallback")
	    public ResponseEntity<UserDto> getUserByIdRestTemplate(@PathVariable("id") Integer id) {
	    	
	        return ResponseEntity.ok(serviceObj.getUserByIdRestTemplate(id));
	    }
	    
	    
	    
	    @GetMapping("/getUserByIdFeign/{id}")
	    @CircuitBreaker(name = "getUserByIdCB", fallbackMethod = "getUserFallback")
	    public ResponseEntity<UserDto> getUserByIdFeign(@PathVariable("id") Integer id) {
	    	
	        return ResponseEntity.ok(serviceObj.getUserByIdFeign(id));  
	    }
	    
	    public ResponseEntity<UserDto> getUserFallback(Integer id, Throwable throwable) {
	        
	    	UserDto userdto=new UserDto();
	    	userdto.setUserId(id);
	    	userdto.setName("fallbackName");
	    	userdto.setEmail("fallback@gmail.com");
	    	userdto.setPassword("fallback@123");
	        return new ResponseEntity<>(userdto,HttpStatus.SERVICE_UNAVAILABLE);
	    }
	  
	    
	    
	   
}
