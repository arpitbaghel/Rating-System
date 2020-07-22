package com.example.rating.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.example.rating.bean.RatingRequestBean;
import com.example.rating.entity.RideEntity;
import com.example.rating.service.RideService;

@Component
public class RideValidator {
	
	@Autowired
	private RideService rideService;

	public void validateOnCustomerRatingUpdate(RatingRequestBean bean, Errors errors) {
		if(!errors.hasErrors()) {
			if(bean == null || bean.getRideId() == null || bean.getRating() == null) {
				errors.reject("Mandatory Fields Missing");
			}
			RideEntity rideEntity = rideService.findByRideId(bean.getRideId());
			if(rideEntity == null) {
				errors.reject("No such Ride");
			}
			if(rideEntity!=null && rideEntity.getCustomerRating()!=null ) {
				errors.reject("Already Rated");
			}
		}
	}
	
	public void validateOnDriverRatingUpdate(RatingRequestBean bean, Errors errors) {
		if(!errors.hasErrors()) {
			if(bean == null || bean.getRideId() == null || bean.getRating() == null) {
				errors.reject("Mandatory Fields Missing");
			}
			RideEntity rideEntity = rideService.findByRideId(bean.getRideId());
			if(rideEntity == null) {
				errors.reject("No such Ride");
			}
			if(rideEntity!=null && rideEntity.getDriverRating()!=null ) {
				errors.reject("Already Rated");
			}
		}
	}
	
}