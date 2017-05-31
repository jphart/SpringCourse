package com.qa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.qa.models.Person;

@Controller
@SessionAttributes("person")
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView handleHome(@RequestParam(value = "firstname", required = true) String firstname,
			@RequestParam(value = "lastname", required = true) String lastname,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "age", required = true) String age) {
		
		Person person = new Person(firstname, lastname, email, Integer.valueOf(age));
		
		return new ModelAndView("afterForm","person",person);
	}
	
	@RequestMapping(value="/nextPage", method=RequestMethod.GET)
	public String nextPage(){
		return "nextPage";
	}
}
