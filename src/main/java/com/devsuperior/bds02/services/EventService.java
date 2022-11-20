package com.devsuperior.bds02.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	

	public EventDTO update(Long id, EventDTO dto) {
		
		Optional<Event> optional = repository.findById(id);
		if(optional.isPresent()) {
			Event event = optional.get();
			event = EventDTO.toEvent(dto, event);
			repository.save(event);
			return new EventDTO(event);
		}
		return null;

	}

	public EventDTO findById(Long id) {
		Optional<Event> Event = repository.findById(id);
		if (Event.isPresent()) {
			return new EventDTO(Event.get());
		} else {
			return null;
		}
	}

}
