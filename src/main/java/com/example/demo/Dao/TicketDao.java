package com.example.demo.Dao;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ticket;
import com.example.demo.repositry.TicketRepo;

@Repository
public class TicketDao {
	@Autowired
	TicketRepo ticketRepo;

//tc.getGmailId(), tc.getMobileNumber(), tc.getPname()
	public Ticket checkTicket(String gmail, String oldmobileNumber, String pname) {
		// TODO Auto-generated method stub

		try {

			if (ticketRepo.existsByMobileNumber(oldmobileNumber)) {

				List<Ticket> findByMobileNumber = ticketRepo.findAllByMobileNumber(oldmobileNumber);
				Ticket tic = null;
				for (Ticket ticket : findByMobileNumber) {
					if (ticket.getPname().equals(pname)) {
						return ticket;
					} else {
						tic = ticket;
					}
				}
				return tic;
			}

			else {
				List<Ticket> tc = null;
				System.out.println("98765432" + tc);
				if (gmail != null) {
					tc = ticketRepo.findAllByGmailId(gmail);
				}
				Ticket tic = null;
				for (Ticket ticket : tc) {
					if (ticket.getPname().equals(pname)) {
						return ticket;
					} else {
						tic = ticket;
					}
				}
				return tic;

			}

		} catch (

		Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new NullPointerException("plse provide old mobile number and email");

		}
	}

	public void deleteById(int id) {
		try {
			Optional<Ticket> findById = ticketRepo.findById(id);
			if (findById != null) {
				ticketRepo.deleteById(id);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		// TODO Auto-generated method stub

	}
}
