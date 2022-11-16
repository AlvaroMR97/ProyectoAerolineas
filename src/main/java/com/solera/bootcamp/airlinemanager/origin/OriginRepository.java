package com.solera.bootcamp.airlinemanager.origin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OriginRepository extends JpaRepository<Origin, Integer> {
	
	@Query("SELECT t FROM Origin t WHERE t.location = ?1")
    Origin findByLocation(String location);
}