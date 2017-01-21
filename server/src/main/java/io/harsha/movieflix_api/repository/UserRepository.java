package io.harsha.movieflix_api.repository;

import java.util.List;

import io.harsha.movieflix_api.entity.Users;
import io.harsha.movieflix_api.entity.Users.RoleType;

public interface UserRepository {

	public List<Users> findAll();

	public Users findOne(String id);

	public Users findByEmail(String email);

	public Users create(Users user);

	public Users update(String id, Users user);

	public void delete(Users user);

	public List<Users> findUserByType(RoleType type);
}
