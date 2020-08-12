package com.travelxy.trainservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelxy.trainservice.clients.UserFeignClient;
import com.travelxy.trainservice.dtos.TicketsDto;
import com.travelxy.trainservice.models.Ticket;
import com.travelxy.trainservice.models.Train;
import com.travelxy.trainservice.models.User;
import com.travelxy.trainservice.repository.TicketRepository;
import com.travelxy.trainservice.repository.TrainRepository;

@Service
public class TrainService {
	@Autowired
	private TrainRepository trainRepo;
	
	@Autowired
	private TicketRepository ticketRepo;
	
	@Autowired
	private UserFeignClient userClient;
	
	public Train getTrainById(Long id) {
		return this.trainRepo.getOne(id);
	}
	
	public Train saveTrainDetails(Train train) {
		return this.trainRepo.saveAndFlush(train);
	}
	
	public Ticket bookTicket(String username, Long trainId) {
		User user = userClient.getUserByUsername(username);
		Train train = trainRepo.getOne(trainId);
		if(train == null) {
			throw new RuntimeException("Invalid train id");
		}
		if(user == null) {
			throw new RuntimeException("Invalid user id");
		}
		Ticket ticket = new Ticket(user.getId(), train);
		this.ticketRepo.saveAndFlush(ticket );
		return ticket;
	}

	public List<Train> getTrains() {
		return this.trainRepo.findAll();
	}
	
	public TicketsDto getAllUserTickets(String username) {
		User user = this.userClient.getUserByUsername(username);
		if(user == null) {
			throw new RuntimeException("Invalid username");
		}
		List<Ticket> tickets = ticketRepo.findAllByUserId(user.getId());
		return new TicketsDto(user, tickets);
		
	}
}
