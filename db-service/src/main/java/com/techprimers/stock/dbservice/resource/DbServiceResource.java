package com.techprimers.stock.dbservice.resource;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.stock.dbservice.model.User;
import com.techprimers.stock.dbservice.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Age DB REST Endpoint")
@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

	private UserRepository quotesRepository;

	public DbServiceResource(UserRepository quotesRepository) {
		this.quotesRepository = quotesRepository;
	}
	@ApiOperation(value = "gets user name and returns User Model")
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") final String username) {

		return getUserByUserName(username);
	}

	@ApiOperation(value = "returns List of Users")
	@GetMapping("/list")
	public List<User> getUserList() {

		return findAll();
	}

	@ApiOperation(value = "add and returns given User ")
	@PostMapping("/add")
	public User add(@RequestBody final User user) {

		quotesRepository.save(user);

		return getUserByUserName(user.getUserName());
	}

	@ApiOperation(value = "deletes user by user name")
	@DeleteMapping("/{username}")
	public void deleteUser(@PathVariable("username") final String username) {

		deleteUserByName(username);
	}
	

	private User getUserByUserName(String username) {
		return quotesRepository.findByUserName(username);
	}

	private List<User> findAll() {

		return quotesRepository.findAll();
	}

	private void deleteUserByName(String username) {

		quotesRepository.delete(getUserByUserName(username));

	}
}
