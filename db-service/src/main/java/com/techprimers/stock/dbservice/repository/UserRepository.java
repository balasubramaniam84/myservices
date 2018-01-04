package com.techprimers.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techprimers.stock.dbservice.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserName(String username);

	List<User> findAll(Specification<User> spec);
}
