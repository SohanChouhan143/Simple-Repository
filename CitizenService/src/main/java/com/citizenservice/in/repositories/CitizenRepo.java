package com.citizenservice.in.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citizenservice.in.entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {
	
	public List<Citizen> findByVaccinationId(Integer id);

}
