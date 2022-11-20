package com.devsuperior.bds02.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repository;

	public List<CityDTO> findAll() {
		List<City> list = repository.findAll(Sort.by("name"));
		List<CityDTO> listDTO = list.stream()
				.map(city -> new CityDTO(city))
				.toList();
		return listDTO;
	}

	public CityDTO insert(CityDTO dto) {
		City city = new City(null, dto.getName());
		city = repository.save(city);
		return new CityDTO(city);
	}

	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	public CityDTO findById(Long id) {
		Optional<City> city = repository.findById(id);
		if(city.isPresent()) {
			return new CityDTO(city.get());
		}else {
			return null;
		}
	}

}
