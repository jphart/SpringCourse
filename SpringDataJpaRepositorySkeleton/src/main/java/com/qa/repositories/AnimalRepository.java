package com.qa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qa.beans.Animal;
@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer>{

}
