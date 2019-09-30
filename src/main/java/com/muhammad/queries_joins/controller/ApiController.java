package com.muhammad.queries_joins.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammad.queries_joins.entities.Country;
import com.muhammad.queries_joins.services.ApiService;

@RestController
public class ApiController {
	
	private final ApiService apiService;

	public ApiController(ApiService apiService) {
		super();
		this.apiService = apiService;
	}
	
	@RequestMapping("/")
	public List<Country> findAllCountries(){
		return apiService.findAllCountries();
	}
}
