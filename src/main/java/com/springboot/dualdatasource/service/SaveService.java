package com.springboot.dualdatasource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dualdatasource.repo1.CityRepo;
import com.springboot.dualdatasource.source1.entity.City;

@Service
public class SaveService {	
	
	@Autowired
	private CityRepo cityRepo;
	
	public void saveCity() {
		City city = new City();
		city.setName("Amritsar");
		cityRepo.save(city);
	}

}
