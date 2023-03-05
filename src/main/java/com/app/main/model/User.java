package com.app.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private int userId;
	
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private int age;
	private String nationality;
	
	
	
	
	
	
}
