package com.app.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.main.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserId(int id);

}
