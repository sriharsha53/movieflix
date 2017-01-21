package io.harsha.movieflix_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.harsha.movieflix_api.entity.Users;
import io.harsha.movieflix_api.entity.Users.RoleType;
import io.harsha.movieflix_api.exception.BadRequestException;
import io.harsha.movieflix_api.exception.EntityNotFoundException;
import io.harsha.movieflix_api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Users> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Users findOne(String id) {
		Users user = repository.findOne(id);
		if (user == null) {
			throw new EntityNotFoundException("User not found");
		}
		return user;
	}

	@Override
	@Transactional
	public Users create(Users user) {
		Users existing = repository.findByEmail(user.getEmail());
		if (existing != null) {
			throw new BadRequestException("User with this email already exists");
		}
		return repository.create(user);
	}

	@Override
	@Transactional
	public Users update(String id, Users user) {
		Users existing = repository.findByEmail(user.getEmail());
		if (existing == null) {
			throw new BadRequestException("User not found");
		}
		return repository.update(id, user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Users existing = repository.findOne(id);
		if (existing == null) {
			throw new BadRequestException("User not found");
		}
		repository.delete(existing);
	}

	@Override
	public List<Users> findUserByType(RoleType type) {
		return repository.findUserByType(type);
	}

}
