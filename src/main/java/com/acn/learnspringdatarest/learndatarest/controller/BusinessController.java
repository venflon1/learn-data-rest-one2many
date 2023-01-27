package com.acn.learnspringdatarest.learndatarest.controller;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;

@RepositoryRestController
@Slf4j
public class BusinessController {
	
    @GetMapping("/employees/business-api") 
	public ResponseEntity<String> doStuff() {
		log.info("getAll START");
		return ResponseEntity.ok("hello");
	}
}