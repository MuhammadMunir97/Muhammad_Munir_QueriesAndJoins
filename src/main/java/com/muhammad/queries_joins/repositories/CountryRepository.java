package com.muhammad.queries_joins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.muhammad.queries_joins.entities.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{
	@Query("SELECT c FROM Country AS c")
	public List<Country> findAll();
	@Query(value="SELECT name, language, percentage FROM countries \r\n" + 
			"JOIN languages ON countries.id = languages.country_id where language = \"Slovene\" order by percentage desc" , nativeQuery=true)
	public List<Object> findAllSloveneSpeakingCountries();
	
	@Query(value="SELECT countries.name,count(cities.id) as number_of_cities FROM cities   \r\n" + 
			"JOIN countries ON countries.id = cities.country_id group by countries.id order by count(cities.id) desc" , nativeQuery=true)
	public List<Object> answerTwo();
	
	@Query(value="SELECT cities.name,cities.population  as population FROM cities  \r\n" + 
			"JOIN countries ON countries.id = cities.country_id  where countries.name= 'Mexico' and cities.population > 500000" , nativeQuery=true)
	public List<Object> findCitiesInMexico();
	
	@Query(value="SELECT name, language, percentage FROM countries \r\n" + 
			"JOIN languages ON countries.id = languages.country_id where languages.percentage > 89 order by percentage desc" , nativeQuery=true)
	public List<Object> languageGreaterThan89();
	
	@Query(value="SELECT countries.name, countries.population, countries.surface_area FROM countries \r\n" + 
			"where surface_area < 501 and countries.population > 100000" , nativeQuery=true)
	public List<Object> SABelow500();
	
	@Query(value="select countries.name, countries.government_form, life_expectancy from countries where government_form = 'Constitutional Monarchy'  \r\n" + 
			" and capital > 200 and life_expectancy > 75" , nativeQuery=true)
	public List<Object> findConstitutionalMonarchy();
	
	@Query(value="select countries.name as country, cities.name as city, cities.district, cities.population from countries \r\n" + 
			"join cities on countries.id = cities.country_id where countries.name = 'Argentina' \r\n" + 
			"and cities.district = 'Buenos Aires' and cities.population > 500000" , nativeQuery=true)
	public List<Object> findCitiesInBADistrict();
	
	@Query(value="select countries.region, count(countries.id) as num_of_countries from countries group by countries.region \r\n" + 
			"order by count(countries.id) desc" , nativeQuery=true)
	public List<Object> findCountriesInRegion();
}
