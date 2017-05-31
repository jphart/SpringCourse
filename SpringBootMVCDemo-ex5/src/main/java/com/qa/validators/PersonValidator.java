package com.qa.validators;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.qa.models.Person;

@Component
public class PersonValidator implements Validator{
	
	String AGE_PATTERN = "[0-9]+"; 

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors err) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "firstname", "firstname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "lastname", "lastname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "email", "email.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "age", "age.empty");
		
		Person p = (Person) obj;
		if (p.getAge() < 0){
			err.reject("age.negative");
		}
		
	}

}
