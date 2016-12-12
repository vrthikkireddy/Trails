package com.journaldev.spring;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AngularController {
	
	private static final Logger logger = LoggerFactory.getLogger(AngularController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/anghome", method = RequestMethod.GET)
	public String anghome(Locale locale, Model model) {
		logger.info("In Angular Controller anghome action");
		return "anghome";
	}
	
	@RequestMapping(value = "/angmvc", method = RequestMethod.GET)
	public String angmvc(Locale locale, Model model) {
		logger.info("In Angular Controller angmvc action");
		userService.saveUser(null);
		model.addAttribute("angresult", "I am good");
		return "angresult";
	}
	
}
