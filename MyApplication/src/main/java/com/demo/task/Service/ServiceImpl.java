package com.demo.task.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.task.BO.BoInterface;
import com.demo.task.Client.FirstAppByFeignClient;
import com.demo.task.Config.RestTemplateConfig;
import com.demo.task.DTO.UserDto;


@Service
public class ServiceImpl implements ServiceInterface{
	
	

	
	

	    @Autowired
	    private BoInterface boObj;
	    @Override
	    public UserDto getUserByIdRestTemplate(Integer id) {
	        return boObj.getUserByIdRestTemplate(id);
	    }

	    @Override
	    public UserDto getUserByIdFeign(Integer id) {
	        return boObj.getUserByIdFeign(id);
	    }
	

	

}
