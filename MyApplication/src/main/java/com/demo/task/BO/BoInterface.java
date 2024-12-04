package com.demo.task.BO;


import com.demo.task.DTO.UserDto;


public interface BoInterface {


	UserDto getUserByIdRestTemplate(Integer id);

	UserDto getUserByIdFeign(Integer id);
	
}
