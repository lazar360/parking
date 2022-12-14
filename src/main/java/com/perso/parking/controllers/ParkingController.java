package com.perso.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.perso.parking.models.Parking;
import com.perso.parking.services.ParkingService;

@RestController
public class ParkingController {
	
	@Autowired
	private ParkingService parkingService;
	
	@CrossOrigin("http://localhost:4200")
	@RequestMapping(path = "/api/parkings", method = RequestMethod.GET)
	public List<Parking> getListeParkings(){
		return parkingService.getListeParkings();
	}
}
