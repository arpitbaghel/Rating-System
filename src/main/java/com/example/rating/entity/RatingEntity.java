package com.example.rating.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.rating.constant.RatingEntityConstants;

@Entity
@Table(name = RatingEntityConstants.TABLE_NAME)
public class RatingEntity implements Serializable, RatingEntityConstants{

	private static final long serialVersionUID = 2184039065627725447L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = RatingEntityConstants.ID)
	private Long id;

	@Column(name = RatingEntityConstants.USER_ID)
	private Long userId;
	
	@Column(name = RatingEntityConstants.USER_TYPE)
	private Integer userType;
	
	@Column(name = RatingEntityConstants.AVG_RATING)
	private Double avgRating;
	
	@Column(name = RatingEntityConstants.TOTAL_RIDES)
	private Long totalRides;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
