package com.javastack.spring.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javastack.spring.dojosninjas.models.Ninja;
import com.javastack.spring.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	//Show All
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	//Create
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
}
