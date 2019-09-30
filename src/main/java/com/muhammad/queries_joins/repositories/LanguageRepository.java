package com.muhammad.queries_joins.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.muhammad.queries_joins.entities.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	
	public List<Language> findAll();
}
