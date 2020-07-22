package com.example.rating.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rating.entity.RideEntity;

@Repository
public interface RideRepository extends CrudRepository<RideEntity, Long>{

	
	@Query(RideEntity.Query.FIND_RIDE)
	RideEntity findRideById(@Param("id") Long id);
	
}
