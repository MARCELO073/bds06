package com.devsuperior.movieflix.repositories;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query("SELECT DISTINCT obj FROM Movie obj INNER JOIN obj.genries cats WHERE "
			+ "(COALESCE(:genries) IS NULL OR cats IN :genries) AND "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))) ")
	Page<Movie> find(List<Genre> genries, String name, Pageable pageable);
	
	@Query("SELECT obj FROM Movie obj JOIN FETCH obj.genries WHERE obj IN :movies")
	List<Movie> findProductsWithCategories(List<Movie> movies);

}
