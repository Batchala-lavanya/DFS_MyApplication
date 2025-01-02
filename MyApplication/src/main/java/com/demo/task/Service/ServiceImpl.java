package com.demo.task.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.task.BO.BoInterface;
import com.demo.task.Client.FirstAppByFeignClient;
import com.demo.task.Config.RestTemplateConfig;
import com.demo.task.DTO.UserDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ServiceImpl implements ServiceInterface{

	    @Autowired
	    private BoInterface boObj;
	    
	    @Override
	    @CircuitBreaker(name = "getUserByIdCB", fallbackMethod = "getUserFallback")
	    public UserDto getUserByIdRestTemplate(Integer id) {
	        return boObj.getUserByIdRestTemplate(id);
	    }
	    
	    
	   
	    @Override
	    @CircuitBreaker(name = "getUserByIdCB", fallbackMethod = "getUserFallback")
	    public UserDto getUserByIdFeign(Integer id) {
	        return boObj.getUserByIdFeign(id);
	    }
	    
	    public UserDto getUserFallback(Integer id, Throwable throwable) {
	        
	    	UserDto userdto=new UserDto();
	    	userdto.setUserId(id);
	    	userdto.setName("fallbackName");
	    	userdto.setEmail("fallback@gmail.com");
	    	userdto.setPassword("fallback@123");
	        return userdto;
	    }
	  

	

}
