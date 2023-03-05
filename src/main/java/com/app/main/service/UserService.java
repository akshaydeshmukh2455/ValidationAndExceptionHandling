package com.app.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.main.dto.UserRequest;
import com.app.main.exception.UserNotFoundException;
import com.app.main.model.User;
import com.app.main.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(UserRequest userRequest)
	{
	User user=User
				.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), 
						userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
	return userRepository.save(user);
	}
	
	public List<User> getAllUser()
	{
		return userRepository.findAll();
		
	}
	
	public User getUser(int id) throws UserNotFoundException
	{
		User user= userRepository.findByUserId(id);
		if(user!=null)
		{
			return user;
		}
		else
		{
			throw new UserNotFoundException("user not found with id "+id);
		}
		
	}

}
