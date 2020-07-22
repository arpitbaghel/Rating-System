package com.example.rating.constant;

public interface RatingEntityConstants {

	String TABLE_NAME = "avg_ratings";
	
	String ID = "id";
	
	String USER_ID = "user_id";
	
	String USER_TYPE = "user_type";
	
	String AVG_RATING = "avg_rating";
	
	String TOTAL_RIDES = "total_rides";
	
	interface Query {
		String FIND_USER_RATING = "select re from RatingEntity re where re.userId = :userId and re.userType = :userType";
	}
}
