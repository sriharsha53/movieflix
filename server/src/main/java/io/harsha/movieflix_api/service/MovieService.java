package io.harsha.movieflix_api.service;

import java.util.List;

import io.harsha.movieflix_api.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findOne(String id);

	public Movie create(Movie movie);

	public Movie update(String id, Movie movie);

	public void delete(String id);

}
