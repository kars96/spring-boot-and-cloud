package com.travelxy.trainservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {
	
	@Id
	@Column(name = "ticket_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketNumber;
	
	@Column(name = "user_id")
	private Long userId;
	
	@ManyToOne
	@JoinColumn(name = "train_id", nullable = false)
	private Train train;

	public Long getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(Long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Ticket(Long ticketNumber, Long userId, Train train) {
		super();
		this.ticketNumber = ticketNumber;
		this.userId = userId;
		this.train = train;
	}

	public Ticket(Long userId, Train train) {
		super();
		this.userId = userId;
		this.train = train;
	}
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	
}
