package com.qa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qa.models.Person;
import com.qa.validators.PersonValidator;

@Controller
//@SessionAttributes("person")
public class HomeController {
	
	
	@Autowired
	private PersonValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("home","person",new Person());
	}

//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public ModelAndView handleHome(@RequestParam(value = "firstname", required = true) String firstname,
//			@RequestParam(value = "lastname", required = true) String lastname,
//			@RequestParam(value = "email", required = true) String email,
//			@RequestParam(value = "age", required = true) String age) {
//				
//		Person person = new Person(firstname, lastname, email, Integer.valueOf(age));
//		
//		return new ModelAndView("afterForm","person",person);
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView handleHome(@ModelAttribute("person") @Validated Person person, BindingResult bindingResult){
		
		if (bindingResult.hasErrors()){
			System.out.println("Person model has errors");
			for(ObjectError error : bindingResult.getAllErrors()){
				System.out.println(error);
			}
			
			System.out.println("Errors, sending to home");
			return new ModelAndView("home");
		}
		System.out.println("Valid person");
		return new ModelAndView("afterForm","person",person);
		
	}
	
	@RequestMapping(value="/nextPage", method=RequestMethod.GET)
	public String nextPage(){
		return "nextPage";
	}
}
