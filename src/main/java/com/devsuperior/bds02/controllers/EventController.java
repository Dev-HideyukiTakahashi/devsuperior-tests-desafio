package com.devsuperior.bds02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.services.EventService;

@RestController
@RequestMapping(path = "/events")
public class EventController {

	@Autowired
	private EventService service;

	@PutMapping(path = "/{id}")
	public ResponseEntity<EventDTO> update(@RequestBody EventDTO dto,@PathVariable Long id) {
		dto = service.update(id, dto);
		if(dto != null) {
			return ResponseEntity.ok(dto);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
