package io.harsha.movieflix_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.harsha.movieflix_api.entity.Movie;
import io.harsha.movieflix_api.exception.BadRequestException;
import io.harsha.movieflix_api.exception.EntityNotFoundException;
import io.harsha.movieflix_api.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Movie findOne(String id) {
		Movie movie = repository.findOne(id);
		if (movie == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return movie;
	}

	@Override
	@Transactional
	public Movie create(Movie movie) {
		Movie existing = repository.findByTitle(movie.getTitle());
		if (existing != null) {
			throw new BadRequestException("Movie with this title already exists");
		}
		return repository.create(movie);
	}

	@Override
	@Transactional
	public Movie update(String id, Movie movie) {
		Movie existing = repository.findByTitle(movie.getTitle());
		if (existing == null) {
			throw new BadRequestException("Movie not found");
		}
		return repository.update(id, movie);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new BadRequestException("Movie not found");
		}
		repository.delete(existing);
	}

}
