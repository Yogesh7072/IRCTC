package com.example.demo.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Bus;
import com.example.demo.model.Ticket;

@Repository
public interface BusRepo extends JpaRepository<Bus, Integer> {

	 Bus findByBusName(String busname);

	@Query(value = "SELECT * FROM Bus WHERE avl_Seat <> 0", nativeQuery = true)
	List<Bus> avlBus();

//	Bus findBySeatNumber(int seatNumber);


}
