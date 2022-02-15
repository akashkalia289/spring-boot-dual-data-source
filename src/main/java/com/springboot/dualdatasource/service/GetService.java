package com.springboot.dualdatasource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dualdatasource.repo2.City1Repo;
import com.springboot.dualdatasource.source2.entity.City1;

@Service
public class GetService {
	
	
	@Autowired
	private City1Repo city1Repo;
	
	public List<City1> getCities(){
		return city1Repo.findAll();
	}
	
	public City1 getCity(Long id) {
		return city1Repo.findById(id).get();
	}

}
