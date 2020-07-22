package com.example.rating.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rating.bean.RatingResponseBean;
import com.example.rating.service.RatingService;

@RestController
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	//To Get Aggregated Rating of Customer Or Driver. userType = 0->customer, 1->driver
	@GetMapping("/rating")
	public RatingResponseBean getRating(@RequestParam(required = true) Long userId, @RequestParam(required = true) Integer userType) {
		RatingResponseBean ratingResponseBean = new RatingResponseBean();
		BeanUtils.copyProperties(ratingService.findRatingByUserId(userId, userType), ratingResponseBean);
		return ratingResponseBean;
	}
	
}
