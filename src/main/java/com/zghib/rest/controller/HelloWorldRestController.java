package com.zghib.rest.controller;

import java.util.List;

import com.zghib.rest.model.UserDocument;
import com.zghib.rest.service.UserDocumentService;
import com.zghib.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zghib.rest.model.User;

@RestController
public class HelloWorldRestController {

	@Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work

	@Autowired
	UserDocumentService userDocumentService;

	
	//-------------------Retrieve All Users--------------------------------------------------------
	
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		System.out.println("Fetching User with id " + id);
		User user = userService.findById(id);
		if (user == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/document/", method = RequestMethod.GET)
	public ResponseEntity<List<UserDocument>> listAllDocuments() {
		List<UserDocument> docs = userDocumentService.findAll();
		if(docs.isEmpty()){
			return new ResponseEntity<List<UserDocument>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserDocument>>(docs, HttpStatus.OK);
	}

	@RequestMapping(value = "/document/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDocument> getUserDocument(@PathVariable("id") int id) {
		System.out.println("Fetching User with id " + id);
		UserDocument userDocument = userDocumentService.findById(id);
		if (userDocument == null) {
			System.out.println("Document with id " + id + " not found");
			return new ResponseEntity<UserDocument>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDocument>(userDocument, HttpStatus.OK);
	}

}
