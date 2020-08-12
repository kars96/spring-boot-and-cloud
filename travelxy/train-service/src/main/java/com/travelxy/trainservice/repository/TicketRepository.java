package com.travelxy.trainservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelxy.trainservice.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

	List<Ticket> findAllByUserId(Long id);

}
