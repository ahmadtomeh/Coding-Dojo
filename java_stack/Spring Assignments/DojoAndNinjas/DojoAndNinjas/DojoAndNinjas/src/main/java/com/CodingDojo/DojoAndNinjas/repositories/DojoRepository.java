package com.CodingDojo.DojoAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.CodingDojo.DojoAndNinjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
}
