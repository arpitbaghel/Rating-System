package com.example.rating.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.rating.constant.RideEntityConstant;


@Entity
@Table(name = RideEntityConstant.TABLE_NAME)
public class RideEntity implements Serializable, RideEntityConstant{

	private static final long serialVersionUID = -2586788723435497475L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = RideEntityConstant.ID)
	private Long id;
	
	@Column(name = RideEntityConstant.CUSTOMER_ID)
	private Long customerID;
	
	@Column(name = RideEntityConstant.DRIVER_ID)
	private Long driverId;
	
	@Column(name = RideEntityConstant.CUSTOMER_RATING)
	private Integer customerRating;
	
	@Column(name = RideEntityConstant.DRIVER_RATING)
	private Integer driverRating;
	
	@Column(name = RideEntityConstant.SOURCE_ID)
	private Long source_id;
	
	@Column(name = RideEntityConstant.DESTINATION_ID)
	private Long destination_id;
	
	@Column(name = RideEntityConstant.CREATED_ON)
	private String createdOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public Long getSource_id() {
		return source_id;
	}

	public void setSource_id(Long source_id) {
		this.source_id = source_id;
	}

	public Long getDestination_id() {
		return destination_id;
	}

	public void setDestination_id(Long destination_id) {
		this.destination_id = destination_id;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getCustomerRating() {
		return customerRating;
	}

	public void setCustomerRating(Integer customerRating) {
		this.customerRating = customerRating;
	}

	public Integer getDriverRating() {
		return driverRating;
	}

	public void setDriverRating(Integer driverRating) {
		this.driverRating = driverRating;
	}

}
