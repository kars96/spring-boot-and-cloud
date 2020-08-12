package com.travelxy.trainservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelxy.trainservice.dtos.TicketsDto;
import com.travelxy.trainservice.models.Ticket;
import com.travelxy.trainservice.models.Train;
import com.travelxy.trainservice.service.TrainService;

@RestController
@RequestMapping("/trains")
public class TrainController {
	
	
	@Autowired
	private TrainService trainServ;
	
	@GetMapping()
	public List<Train> getTrains() {
		return this.trainServ.getTrains();
	}
	
	@PostMapping("tickets/username/{username}/train/{trainId}")
	public Ticket bookTicket(@PathVariable() String username, @PathVariable Long trainId) {
		return 	trainServ.bookTicket(username, trainId);
	}
	
	@PostMapping()
	public ResponseEntity<Object> saveTrain(@RequestBody() Train train) {
		Train res = this.trainServ.saveTrainDetails(train);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@GetMapping("tickets/{username}")
	public ResponseEntity<TicketsDto> getAllUserTickets(@PathVariable() String username) {
		TicketsDto userTickets = trainServ.getAllUserTickets(username);
		return new ResponseEntity(userTickets, HttpStatus.FOUND);
	}
}
