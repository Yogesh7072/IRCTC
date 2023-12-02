package com.example.demo.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.customException.SetNotAvalable;
import com.example.demo.model.Bus;
import com.example.demo.model.PassangerDetails;
import com.example.demo.model.Ticket;
import com.example.demo.repositry.BusRepo;
import com.example.demo.repositry.TicketRepo;

@Repository
public class BusDao {
	private BusRepo busRepo;

	@Autowired
	public BusDao(BusRepo busRepo) {
		this.busRepo = busRepo;
	}

	@Autowired
	TicketRepo ticketRepo;

	public int checkAvlSeat(String busname, BusRepo busRepo) {
		System.out.println(busname);
		if (busname != null) {
			System.out.println(busname);
			Bus findByBusName = this.busRepo.findByBusName(busname);
			System.out.println(busname);
			int avlSeat = findByBusName.getAvlSeat();

			if (avlSeat > 0) {
//				findByBusName.setAvlSeat(avlSeat - 1);
//				this.busRepo.save(findByBusName);
				return avlSeat;
			} else
				return 0;

		} else {
			throw new NullPointerException("busname is null plse provide bus name ");
		}

	}

	@Transactional(rollbackOn = Exception.class)
	public List<Ticket> saveAllGenerateTicket(List<Ticket> list) {

		try {
			List<Ticket> savedTickets = null;
			Iterable<Ticket> ab = list;
			BusDao dao = new BusDao(busRepo);

			Ticket ticket = list.get(0);
			System.out.println(ticket.getBus().getBusName() + "123456789");
			int checkAvlSeat = dao.checkAvlSeat(ticket.getBus().getBusName(), busRepo);

			if (list.size() <= checkAvlSeat) {
				savedTickets = ticketRepo.saveAll(ab);

				BusDao bus = new BusDao(busRepo);
				int avlSeat = bus.checkAvlSeat(ticket.getBus().getBusName(), busRepo);
				Bus findByBusName = this.busRepo.findByBusName(ticket.getBus().getBusName());

				System.out.println(avlSeat);
				if (avlSeat > 0 && avlSeat - list.size() > 0) {
					System.out.println(avlSeat + "System.out.println(avlSeat);\r\n" + "");

					findByBusName.setAvlSeat(avlSeat - (list.size()));
					this.busRepo.save(findByBusName);

				} else {
					throw new SetNotAvalable("set not avalable custom exception");

				}
			}
			return savedTickets;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	public Bus getbus(String busname) {
		try {
			Bus findByBusName = busRepo.findByBusName(busname);

			if (findByBusName != null) {
				return findByBusName;

			} else {
				throw new NullPointerException("this bus not aval");

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new NullPointerException("this bus not aval");

		}

	}

	public List<Bus> getallBus() {
		// TODO Auto-generated method stub

		List<Bus> findAll = busRepo.findAll();
		return findAll;
	}

	public List<Bus> avlBus() {
		// TODO Auto-generated method stub

		List<Bus> findAll = busRepo.avlBus();
		return findAll;
	}

	public Ticket UpdateSave(Ticket ticket) {
		// TODO Auto-generated method stub

		return ticketRepo.save(ticket);

	}

	public boolean isavlSetnumber(int setnum) {
		// TODO Auto-generated method stub
		boolean isavl = false;
		try {
			boolean bus = ticketRepo.existsBySeatnumber(setnum);

			if (bus) {
				isavl = true;

			}

			return isavl;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return isavl;
		}

	}

}
