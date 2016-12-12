package com.journaldev.spring;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.spring.service.UserService;
 
@RestController
public class HelloWorldRestController {
 
	@Autowired
	UserService userService;
    
    @RequestMapping(value = "/rest1/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
    	userService.saveUser(null);
     return null;
    }
    
    @RequestMapping(value = "/rest2/", method = RequestMethod.GET)
    public ResponseEntity<Void> createUser() {
        HttpHeaders headers = new HttpHeaders();
        userService.saveUser(null);
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
}