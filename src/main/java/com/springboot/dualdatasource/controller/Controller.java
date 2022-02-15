package com.springboot.dualdatasource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dualdatasource.service.GetService;
import com.springboot.dualdatasource.service.SaveService;
import com.springboot.dualdatasource.source2.entity.City1;

@RestController
public class Controller {
	
	@Autowired
	private SaveService saveService;
	
	@Autowired
	private GetService getService;

	@GetMapping("/save")
	public void first() {
		saveService.saveCity();
	}
	
	@GetMapping("/get-citites")
	public ResponseEntity<List<City1>> getCitites() {
		return new ResponseEntity<List<City1>>(this.getService.getCities(), HttpStatus.OK);
	}
	
	@GetMapping("/getCity/{id}")
	public ResponseEntity<City1> getCity(@PathVariable("id") Long id) {
		return new ResponseEntity<City1>(this.getService.getCity(id), HttpStatus.OK);
	}
	
}
