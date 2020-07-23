package com.example.rating.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

import com.example.rating.bean.RatingRequestBean;
import com.example.rating.entity.RatingEntity;
import com.example.rating.entity.RideEntity;
import com.example.rating.repository.RideRepository;

@Service
public class RideServiceImpl implements RideService{

	@Autowired
	private RideRepository rideRepository;
	
	@Autowired
	private RatingService ratingService;

	@Override
	public RideEntity saveRide(RideEntity rideEntity) {
		return rideRepository.save(rideEntity);
	}

	@Override
	public RideEntity updateRide(RideEntity rideEntity) {
		return rideRepository.save(rideEntity);
	}
	
	@Override
	public RideEntity findByRideId(Long id) {
		return rideRepository.findRideById(id);
	}
	
	@Override
	public void updateCustomerRating(RatingRequestBean customerRatingRequestBean) {
		RideEntity rideEntity = findByRideId(customerRatingRequestBean.getRideId()); 
		rideEntity.setCustomerRating(customerRatingRequestBean.getRating());
		//Async call to update Customer Aggregated Rating to reduce latency
		CompletableFuture.runAsync(() -> {
			ratingUpdate(rideEntity.getCustomerID(), 0, customerRatingRequestBean.getRating());
		});
		updateRide(rideEntity);
	}
	
	@Override
	public void updateDriverRating(RatingRequestBean driverRatingRequestBean) {
		RideEntity rideEntity = findByRideId(driverRatingRequestBean.getRideId()); 
		rideEntity.setDriverRating(driverRatingRequestBean.getRating());
		//Async call to update Driver Aggregated Rating to reduce latency
		CompletableFuture.runAsync(() -> {
			ratingUpdate(rideEntity.getDriverId(), 1, driverRatingRequestBean.getRating());
		});
		updateRide(rideEntity);
	}

	private void ratingUpdate(Long userId, Integer userType, Integer userRating) {
		RatingEntity ratingEntity = ratingService.findRatingByUserId(userId, userType);
		if(ratingEntity!=null) {
			Double oldAvgRating = ratingEntity.getAvgRating();
			Long oldTotalRides = ratingEntity.getTotalRides();
			Long newTotalRides = oldTotalRides+1;
			Double newAvgRating = ((oldAvgRating*Double.valueOf(oldTotalRides))+Double.valueOf(userRating))/Double.valueOf(newTotalRides);
			ratingEntity.setAvgRating(newAvgRating);
			ratingEntity.setTotalRides(newTotalRides);
			ratingService.updateRating(ratingEntity);
		}else {
			RatingEntity newRating = new RatingEntity();
			newRating.setUserId(userId);
			newRating.setTotalRides(1l);
			newRating.setUserType(userType);
			newRating.setAvgRating(Double.valueOf(userRating));
			ratingService.saveRating(newRating);
		}
	}
	

	
}
