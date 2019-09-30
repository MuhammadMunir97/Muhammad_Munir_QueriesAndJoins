package com.muhammad.queries_joins.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.muhammad.queries_joins.entities.City;
import com.muhammad.queries_joins.entities.Country;
import com.muhammad.queries_joins.entities.Language;
import com.muhammad.queries_joins.repositories.CityRepository;
import com.muhammad.queries_joins.repositories.CountryRepository;
import com.muhammad.queries_joins.repositories.LanguageRepository;

@Service
public class ApiService {

	private final CityRepository cityRepo;
	private final LanguageRepository languageRepo;
	private final CountryRepository countryRepo;
	
	public ApiService(CityRepository cityRepo, LanguageRepository languageRepo, CountryRepository countryRepo) {
		super();
		this.cityRepo = cityRepo;
		this.languageRepo = languageRepo;
		this.countryRepo = countryRepo;
	}
	
	public List<Country> findAllCountries(){
		return countryRepo.findAll();
	}
	
	public Country findCountryById(Long id) {
		Optional <Country> country = countryRepo.findById(id);
		if(country.isPresent()) {
			return country.get();
		}else {
			return null;
		}
	}
	
	public List<Object> findCountriesInRegion(){
		return countryRepo.findCountriesInRegion();
	}
	
	public List<Object> findAllCitiesBADistrict(){
		return countryRepo.findCitiesInBADistrict();
	}
	
	public List<Object> findAllConstitutionalMonarychy(){
		return countryRepo.findConstitutionalMonarchy();
	}
	
	public List<Object> findCitiesInMexicoWithPopulationGreater(){
		return countryRepo.findCitiesInMexico();
	}
	
	public List<Object> LanguageGreaterThan89(){
		return countryRepo.languageGreaterThan89();
	}
	
	public List<Object> findSAGreaterThan500(){
		return countryRepo.SABelow500();
	}
	
	public List<Object> findSloveneSpeakingCountries(){
		return countryRepo.findAllSloveneSpeakingCountries();
	}
	
	public List<Object> findCountriesAndNumCities(){
		return countryRepo.answerTwo();
	}
	
	public List<City> findAllCities(){
		return cityRepo.findAll();
	}
	
	public List<Language> findAllLanguages(){
		return languageRepo.findAll();
	}
	
}
