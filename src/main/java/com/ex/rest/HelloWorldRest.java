package com.ex.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hw")
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class HelloWorldRest {
	
	@GetMapping(value="/holaMundo")
	public ResponseEntity<?> registrarSolicitud(){
		
		return ResponseEntity.status(HttpStatus.OK).body("Hello World in AWS!");
	}

}
