package com.example.rating.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;


public class RatingRequestBean implements Serializable {

	private static final long serialVersionUID = -445636429326659299L;

	@NotNull
	private Long rideId;

	@NotNull
	private Integer rating;

	public Long getRideId() {
		return rideId;
	}

	public void setRideId(Long rideId) {
		this.rideId = rideId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
}
