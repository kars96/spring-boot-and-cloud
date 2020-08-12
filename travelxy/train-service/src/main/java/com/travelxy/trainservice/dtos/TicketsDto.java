package com.travelxy.trainservice.dtos;

import java.util.List;

import com.travelxy.trainservice.models.Ticket;
import com.travelxy.trainservice.models.User;

public class TicketsDto {
	private User user;
	private List<Ticket> tickets;
	
	public TicketsDto() {	}

	public TicketsDto(User user, List<Ticket> tickets) {
		super();
		this.user = user;
		this.tickets = tickets;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
}
