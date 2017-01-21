package io.harsha.movieflix_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.harsha.movieflix_api.entity.Users;
import io.harsha.movieflix_api.entity.Users.RoleType;
import io.harsha.movieflix_api.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Users> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{type}")
	public List<Users> findUserByType(@PathVariable("type") String type) {
		return service.findUserByType(RoleType.valueOf(type));
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Users findOne(@PathVariable("id") String userId) {
		return service.findOne(userId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Users create(@RequestBody Users user) {
		return service.create(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Users update(@PathVariable("id") String id, @RequestBody Users user) {
		return service.update(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}
