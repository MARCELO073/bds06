package com.devsuperior.movieflix.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository Repository;
	
	@Autowired
	private GenreRepository genreRepository;

	@Transactional(readOnly = true)
	public Page<MovieDTO> findAllPaged(Long genreId, String name, Pageable pageable) {
		List<Genre> genries = (genreId == 0) ? null : Arrays.asList(genreRepository.getOne(genreId));
		Page<Movie> list = Repository.find(genries, name, pageable);
		return list.map(x -> new MovieDTO(x));
	}
}
