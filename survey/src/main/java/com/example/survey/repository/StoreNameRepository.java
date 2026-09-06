package com.example.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.survey.Entity.StoreNameEntity;


public interface StoreNameRepository extends JpaRepository<StoreNameEntity, Integer>{
	
	@Query("SELECT s.flag FROM StoreNameEntity s WHERE s.id = :id")
	Integer checkFlag(@Param("id") Integer id);
}
