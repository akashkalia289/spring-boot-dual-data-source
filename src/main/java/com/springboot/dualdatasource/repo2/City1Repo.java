package com.springboot.dualdatasource.repo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.dualdatasource.source2.entity.City1;

@Repository
public interface City1Repo extends JpaRepository<City1, Long> {

}
