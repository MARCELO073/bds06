package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.movieflix.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String findByEmail);
	
}
