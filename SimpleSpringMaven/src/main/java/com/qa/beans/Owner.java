package com.qa.beans;

import java.util.List;

public class Owner {

	private String name;
	
	List<Pet> pets;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("OwnerName: "+this.name);
		sb.append("\n");
		sb.append("\n");
		sb.append("Pets: ");
		
		for(Pet p : pets){
			sb.append(p.getName());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
}
