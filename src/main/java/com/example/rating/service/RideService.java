package com.example.rating.service;


import com.example.rating.bean.RatingRequestBean;
import com.example.rating.entity.RideEntity;

public interface RideService {

	RideEntity saveRide(RideEntity rideEntity);
	
	RideEntity updateRide(RideEntity rideEntity);
	
	RideEntity findByRideId(Long id);

	void updateCustomerRating(RatingRequestBean customerRatingRequestBean);
	
	void updateDriverRating(RatingRequestBean driverRatingRequestBean);

}
