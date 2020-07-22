package com.example.rating.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rating.entity.RatingEntity;
import com.example.rating.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public RatingEntity saveRating(RatingEntity ratingEntity) {
		return ratingRepository.save(ratingEntity);
	}

	@Override
	public RatingEntity updateRating(RatingEntity ratingEntity) {
		return ratingRepository.save(ratingEntity);
	}
	
	@Override
	public RatingEntity findRatingByUserId(Long userId, Integer userType) {
		return ratingRepository.findUserRatingByUserId(userId, userType);
	}
	
	
}
