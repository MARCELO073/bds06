package com.devsuperior.movieflix.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.services.GenreService;

@RestController
@RequestMapping(value = "/genries")
public class Genrecontroller {
	
	@Autowired
	GenreService service;

	@GetMapping
	public ResponseEntity<Page<GenreDTO>> findAll(Pageable pageable){
		Page<GenreDTO> list = service.findAllPaged( pageable);
		return ResponseEntity.ok().body(list);
	}
	
}
