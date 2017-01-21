package io.harsha.movieflix_api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.harsha.movieflix_api.entity.Users;
import io.harsha.movieflix_api.entity.Users.RoleType;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Users> findAll() {
		TypedQuery<Users> query = em.createNamedQuery("User.findAll", Users.class);
		return query.getResultList();
	}

	@Override
	public Users findOne(String id) {
		return em.find(Users.class, id);
	}

	@Override
	public Users findByEmail(String email) {
		TypedQuery<Users> query = em.createNamedQuery("User.findByTitle", Users.class);
		query.setParameter("uEmail", email);

		List<Users> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Users create(Users user) {
		em.persist(user);
		return user;
	}

	@Override
	public Users update(String id, Users user) {
		return em.merge(user);
	}

	@Override
	public void delete(Users user) {
		em.remove(user);
	}

	@Override
	public List<Users> findUserByType(RoleType type) {
		TypedQuery<Users> query = em.createNamedQuery("User.findByType", Users.class);
		query.setParameter("uType", type.name());

		List<Users> users = query.getResultList();
		if (users != null) {
			return users;
		} else {
			return null;
		}
	}

}
