package com.app.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.main.dto.UserRequest;
import com.app.main.exception.UserNotFoundException;
import com.app.main.model.User;
import com.app.main.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest)
	{
		return new ResponseEntity<>(service.saveUser(userRequest),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> getAllUsers()
	{
		return ResponseEntity.ok(service.getAllUser());
		
	}
	
	@GetMapping("/singleUser/{id}")
	public ResponseEntity<User> getuser(@PathVariable int id) throws UserNotFoundException
	{
		return ResponseEntity.ok(service.getUser(id));
		
	}
}
