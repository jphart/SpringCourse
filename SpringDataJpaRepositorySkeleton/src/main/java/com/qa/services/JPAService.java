package com.qa.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.beans.Animal;
import com.qa.beans.Owner;
import com.qa.repositories.AnimalRepository;
import com.qa.repositories.OwnerRepository;

@Service
public class JPAService {

	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	public void saveOwners(Owner... owners){
		
		for(Owner owner : owners)
		{
			ownerRepository.save(owner);
		}
		
	}

	public void saveAnimal(Animal a) {
		
		animalRepository.save(a);
		
	}

	public Iterable<Owner> getAllOwners() {
		
		return ownerRepository.findAll();
	}
	
	public Iterable<Animal> getAllAnimals() {
				
		return animalRepository.findAll();
	}
	
	public Animal findById(int id){
		return animalRepository.findOne(id);
	}
	

	
	
}
