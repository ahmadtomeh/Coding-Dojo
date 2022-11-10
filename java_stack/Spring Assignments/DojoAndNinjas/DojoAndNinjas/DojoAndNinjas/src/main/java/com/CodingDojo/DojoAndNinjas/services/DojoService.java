package com.CodingDojo.DojoAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CodingDojo.DojoAndNinjas.models.Dojo;
import com.CodingDojo.DojoAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService (DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojos = dojoRepository.findById(id);
		if (optionalDojos.isPresent()) {
			return optionalDojos.get();
		} else {
			return null;
		}
	}
	
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public void deleteDojo(Long id) {
		Optional<Dojo> optionalDojos = dojoRepository.findById(id);
		if (optionalDojos.isPresent()) {
			dojoRepository.deleteById(id);
		}
	}
}
