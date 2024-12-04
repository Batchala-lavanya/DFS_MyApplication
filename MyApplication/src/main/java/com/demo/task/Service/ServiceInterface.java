package com.demo.task.Service;

import com.demo.task.DTO.UserDto;

public interface ServiceInterface {
	
	

	UserDto getUserByIdFeign(Integer id);

	UserDto getUserByIdRestTemplate(Integer id);
		
	

}
