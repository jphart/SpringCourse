package com.qa.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Owner")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int ownerID;

	@OneToMany(	fetch = FetchType.EAGER, 
				mappedBy = "ownerID")
	private List<Animal> animals;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String emailAddress;

	public Owner() {
		animals = new ArrayList<Animal>();
	}

	public Owner(int ownerID, String name, String emailAddress) {

		this.ownerID = ownerID;
		this.name = name;
		this.emailAddress = emailAddress;

		animals = new ArrayList<Animal>();
	}

	public Animal getAnimal(int animalID) {
		for (Animal a : animals) {
			if (a.getAnimalID() == animalID)
				return a;
		}
		return null;
	}

	public void addAnimal(Animal a) {
		this.animals.add(a);
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public ArrayList<Animal> getAnimals() {
		return new ArrayList<Animal>(animals);
	}

	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}
 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String toString(){
		String s = ownerID + ": " + name + ", " + emailAddress + "\n Number of Animals: " + animals.size() + "\n";
		for(Animal a : animals){
			s += a + "\n";
		}
		
		return s;
	}
}
