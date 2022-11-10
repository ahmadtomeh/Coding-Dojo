package com.CodingDojo.DojoAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CodingDojo.DojoAndNinjas.models.Ninja;
import com.CodingDojo.DojoAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
private final NinjaRepository ninjaRepository;
	
	public NinjaService (NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinjas = ninjaRepository.findById(id);
		if (optionalNinjas.isPresent()) {
			return optionalNinjas.get();
		} else {
			return null;
		}
	}
	
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public void deleteNinja(Long id) {
		Optional<Ninja> optionalNinjas = ninjaRepository.findById(id);
		if (optionalNinjas.isPresent()) {
			ninjaRepository.deleteById(id);
		}
	}
}
