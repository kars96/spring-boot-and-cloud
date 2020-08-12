package com.travelxy.trainservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelxy.trainservice.models.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long>{

}
