package com.example.rating.service;

import com.example.rating.bean.RatingResponseBean;
import com.example.rating.entity.RatingEntity;

public interface RatingService {
	
	RatingEntity findRatingByUserId(Long userId, Integer userType);
	
	RatingEntity saveRating(RatingEntity ratingEntity);
	
	RatingEntity updateRating(RatingEntity ratingEntity);
	
}
