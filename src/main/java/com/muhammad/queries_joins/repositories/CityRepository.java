package com.muhammad.queries_joins.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.muhammad.queries_joins.entities.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{
	
	public List<City> findAll();
}
