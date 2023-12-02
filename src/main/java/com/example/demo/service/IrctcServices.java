package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TicketDto;
import com.example.demo.model.Bus;
import com.example.demo.model.PassangerDetails;
import com.example.demo.model.Ticket;

public interface IrctcServices {

	List<TicketDto> generateTicket(List<PassangerDetails> tc);


	void cancleTicket(int id);

	Ticket getTicketDetails(int tid);

	List<Ticket> getallTicket();

	List<Ticket> getallTicketPerticularDate();

	Ticket getAllTicketPerticularBusNUmber(int bid);

	List<Bus> getBuses();


	


	List<TicketDto> updateTicket(List<PassangerDetails> pc);


}
