package com.example.rating.controller;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rating.bean.RatingRequestBean;
import com.example.rating.service.RideService;
import com.example.rating.validator.RideValidator;

@RestController
public class RideController {

	@Autowired
	private RideService rideService;
	
	@Autowired
	private RideValidator rideValidator;
	
	
	//calledByDriver to give rating to customer 
	@PutMapping("/ride/customer-rating")
	public void customerRating(@RequestBody @Valid RatingRequestBean customerRatingRequestBean, Errors errors) {
		rideValidator.validateOnCustomerRatingUpdate(customerRatingRequestBean, errors);
		if (errors.hasErrors()) {
			throw new ValidationException((Throwable) errors.getAllErrors());
		}
		rideService.updateCustomerRating(customerRatingRequestBean);
	}
	
	//calledByCustomer to give rating to driver 
	@PutMapping("/ride/driver-rating")
	public void driverRating(@RequestBody @Valid RatingRequestBean driverRatingRequestBean, Errors errors) {
		rideValidator.validateOnDriverRatingUpdate(driverRatingRequestBean, errors);
		if (errors.hasErrors()) {
			throw new ValidationException((Throwable) errors.getAllErrors());
		}
		rideService.updateDriverRating(driverRatingRequestBean);
	}
	
	
}
