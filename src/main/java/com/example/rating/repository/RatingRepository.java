package com.example.rating.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rating.entity.RatingEntity;

@Repository
public interface RatingRepository extends CrudRepository<RatingEntity, Long>{

	@Query(RatingEntity.Query.FIND_USER_RATING)
	RatingEntity findUserRatingByUserId(@Param("userId") Long userId, @Param("userType") Integer userType);
	
}
