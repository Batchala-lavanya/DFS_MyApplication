package com.demo.task.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.task.Client.FirstAppByFeignClient;
import com.demo.task.Config.RestTemplateConfig;
import com.demo.task.DTO.UserDto;
import com.demo.task.Service.ServiceInterface;
@Service
public class BoImpl implements BoInterface{
	    
	    

	    @Autowired
	    private RestTemplateConfig restTemplateConfig;

	    @Autowired
	    private FirstAppByFeignClient feignClientHelper;

	    @Override
	    public UserDto getUserByIdRestTemplate(Integer id) {
	        return restTemplateConfig.getUserById(id).getBody();
	    }

	    @Override
	    public UserDto getUserByIdFeign(Integer id) {
	        return feignClientHelper.getUserById(id).getBody();
	    }
	

	
}
