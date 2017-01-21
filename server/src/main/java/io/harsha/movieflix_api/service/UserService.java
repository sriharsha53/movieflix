package io.harsha.movieflix_api.service;

import java.util.List;

import io.harsha.movieflix_api.entity.Users;
import io.harsha.movieflix_api.entity.Users.RoleType;

public interface UserService  {
	public List<Users> findAll();

	public Users findOne(String id);

	public Users create(Users user);

	public Users update(String id, Users user);

	public void delete(String id);

	public List<Users> findUserByType(RoleType type);

}
