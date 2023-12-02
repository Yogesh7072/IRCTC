package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TicketDto;
import com.example.demo.model.Bus;
import com.example.demo.model.PassangerDetails;
import com.example.demo.model.Ticket;
import com.example.demo.service.serviceImp.BookTicket;

@RestController
public class TicketController {

	@Autowired
	BookTicket ticketservice;

	@PostMapping("/createticket")
	public ResponseEntity<List<TicketDto>> responsebookseats(@RequestBody List<PassangerDetails> ps) {
		System.out.println("start controller");

		List<TicketDto> generateTicket = ticketservice.generateTicket(ps);
		System.out.println("ticketservice  :  " + generateTicket);

		if (generateTicket != null) {
			System.out.println(generateTicket);
			return new ResponseEntity<List<TicketDto>>(generateTicket, HttpStatus.CREATED);

		} else {
			throw new NullPointerException("ticket is null plse check it");
		}

	}

	@PutMapping("/changeticket")
	public ResponseEntity<List<TicketDto>> update(@RequestBody List<PassangerDetails> tc) {
		System.out.println(tc.get(0));
		List<TicketDto> updateTicket = ticketservice.updateTicket(tc);

		return new ResponseEntity<List<TicketDto>>(updateTicket, HttpStatus.OK);

	}

	@GetMapping("/getAllBus")
	public ResponseEntity<List<Bus>> allBus() {
		List<Bus> bus = ticketservice.getBuses();

		return new ResponseEntity<List<Bus>>(bus, HttpStatus.OK);

	}

	@GetMapping("/avlBus")
	public ResponseEntity<List<Bus>> avlBus() {
		List<Bus> bus = ticketservice.avlbus();

		return new ResponseEntity<List<Bus>>(bus, HttpStatus.OK);

	}

}
