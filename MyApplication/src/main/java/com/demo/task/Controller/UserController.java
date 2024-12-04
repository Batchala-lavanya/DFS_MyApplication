package com.demo.task.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/api/user")
public class UserController {
	 	
	    @Autowired
	    private ServiceInterface serviceObj;

	    @GetMapping("/getUserByIdRestTemplate/{id}")
	    public ResponseEntity<UserDto> getUserByIdRestTemplate(@PathVariable("id") Integer id) {
	        return ResponseEntity.ok(serviceObj.getUserByIdRestTemplate(id));
	    }

	    @GetMapping("/getUserByIdFeign/{id}")
	    public ResponseEntity<UserDto> getUserByIdFeign(@PathVariable("id") Integer id) {
	        return ResponseEntity.ok(serviceObj.getUserByIdFeign(id));
	    }

}
