package com.example.demo.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	Ticket findByMobileNumber(String mobileNumber);
	// List<Ticket> findByAllMobileNumber(String mobileNumber);

	@Query("SELECT t FROM Ticket t WHERE t.mobileNumber = :mobileNumber")
	List<Ticket> findAllByMobileNumber(@Param("mobileNumber") String mobileNumber);

	@Query("SELECT t FROM Ticket t WHERE t.gmailId = :gmailId")
	List<Ticket> findAllByGmailId(@Param("gmailId") String gmailId);

	
	boolean existsBySeatnumber(int seatNumber);

	Ticket findByGmailId(String gmailId);

	boolean existsByMobileNumber(String oldmobileNumber);

}
