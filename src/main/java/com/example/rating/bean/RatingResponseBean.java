package com.example.rating.bean;

import java.io.Serializable;


public class RatingResponseBean implements Serializable {
	
	private static final long serialVersionUID = -6327057643524356859L;
	
	private Long userId;

	private Integer userType;
	
	private Double avgRating;
	
	private Long totalRides;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	public Long getTotalRides() {
		return totalRides;
	}

	public void setTotalRides(Long totalRides) {
		this.totalRides = totalRides;
	}
}
