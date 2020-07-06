package com.sba.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sba.pm.entity.UserEntity;
import com.sba.pm.services.impl.UserServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/user/saveOrUpdateUser")
	public Integer createOrUpdate(@RequestBody UserEntity userEntity) {
		return userService.saveOrUpdateUser(userEntity);
	}
	
	@GetMapping("/user/getUser/{id}")
	public UserEntity getUser(@PathVariable String id) {
		return userService.getUser(Integer.parseInt(id));
		
		
	}
	
	@GetMapping("/user/getAllUsers")
	public List<UserEntity> getAllUsers(){
		return userService.getAllUsers();
		
	}
	
	@DeleteMapping("/user/deleteUser/{id}")
	public Integer deleteUser(@PathVariable String id) {
		return userService.deleteUser(Integer.parseInt(id));
	}

}
