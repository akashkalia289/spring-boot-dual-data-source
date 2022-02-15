package com.springboot.dualdatasource.repo1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.dualdatasource.source1.entity.City;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {

}
