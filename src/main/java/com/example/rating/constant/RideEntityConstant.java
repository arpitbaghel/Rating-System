package com.example.rating.constant;

public interface RideEntityConstant {

	String TABLE_NAME = "rides";
	
	String ID = "id";
	
	String CUSTOMER_ID = "customer_id";
	
	String DRIVER_ID = "driver_id";
	
	String CUSTOMER_RATING = "customer_rating";
	
	String DRIVER_RATING = "driver_rating";
	
	String SOURCE_ID = "source_id";
	
	String DESTINATION_ID = "destination_id";
	
	String CREATED_ON = "created_on";

	interface Query {
		String FIND_RIDE = "select re from RideEntity re where re.id = :id";
	}
	
}
