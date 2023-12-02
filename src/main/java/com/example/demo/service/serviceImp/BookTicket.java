package com.example.demo.service.serviceImp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.BusDao;
import com.example.demo.Dao.TicketDao;
import com.example.demo.dto.TicketDto;
import com.example.demo.model.Bus;
import com.example.demo.model.PassangerDetails;
import com.example.demo.model.Ticket;
import com.example.demo.service.IrctcServices;

@Service
public class BookTicket implements IrctcServices {
	@Autowired
	BusDao busdao;

	@Autowired
	TicketDao ticketDao;

	@Override
	public List<TicketDto> generateTicket(List<PassangerDetails> pc) {
		System.out.println("generateTicket");
		BookTicket tc = new BookTicket();
		List<Ticket> list = tc.generate(pc, busdao);

		System.out.println(list);

		List<Ticket> responseList = busdao.saveAllGenerateTicket(list);
		System.out.println("responseList" + responseList);
		if (responseList != null) {

			List<TicketDto> responseObject = new ArrayList<TicketDto>();
			for (int i = 0; i < responseList.size(); i++) {

				Ticket ls = responseList.get(i);

				TicketDto responseDto = convertDtoObject(ls, busdao);

				responseObject.add(responseDto);
			}

			return responseObject;
		} else {

			return null;
		}
	}

	private TicketDto convertDtoObject(Ticket ls, BusDao busdao) {
		// TODO Auto-generated method stub

		TicketDto dto = new TicketDto();
		dto.setTid(ls.getTid());

		dto.setPname(ls.getPname());
		dto.setSeatnumber(ls.getSeatnumber());

		dto.setBusStratPint(ls.getBus().getBusStratPint());
		dto.setBusEndPoint(ls.getBus().getBusEndPoint());
		dto.setPickupPoint(ls.getPickupPoint());
		dto.setDropPoint(ls.getDropPoint());
		dto.setBusEndPoint(ls.getDropPoint());
		dto.setBusNumber(ls.getBus().getBusNumber());
		dto.setBusStartTime(ls.getBus().getBusStartTime());
		dto.setBusEndTime(ls.getBus().getBusEndTime());
		dto.setBusName(ls.getBus().getBusName());
		dto.setBusRoot(ls.getBus().getBusRoot());
		dto.setMobileNumber(ls.getMobileNumber());
		dto.setPayment(ls.getPayment());

		return dto;
	}

	private List<Ticket> generate(List<PassangerDetails> pc, BusDao busdao) {
		// TODO Auto-generated method stub
		try {
			System.out.println("generate");
			List<Ticket> ticket = new ArrayList<Ticket>();

			if (pc != null) {
				for (int i = 0; i < pc.size(); i++) {
					Ticket tc = new Ticket();
					PassangerDetails passanger = pc.get(i);

					tc.setTid(passanger.getPid());
					tc.setDropPoint(passanger.getDropPoint());
					tc.setMobileNumber(passanger.getMobileNumber());
					tc.setPickupPoint(passanger.getPickupPoint());
					tc.setPname(passanger.getPname());
					tc.setPayment(new Random().nextInt(1000) + 2000);
					tc.setGmailId(passanger.getGmailId());

					int avlseats = busdao.checkAvlSeat(passanger.getBusname(), null);
					Bus bus = busdao.getbus(passanger.getBusname());
					tc.setBus(bus);

					int allseat = 44;
					if (avlseats >= 1)
						tc.setSeatnumber(allseat - (--avlseats));
					else
						throw new NullPointerException();
					ticket.add(tc);
				}
				return ticket;

			} else {

				throw new NullPointerException("pssanger details is null plse provide this currect details");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<TicketDto> updateTicket(List<PassangerDetails> pc) {
		// TODO Auto-generated method stub
		try {

			List<TicketDto> ls = new ArrayList<TicketDto>();
			for (int i = 0; i <= pc.size() - 1; i++) {
				PassangerDetails tc = pc.get(i);
				System.out.println(tc.getGmailId() + "  " + tc.getMobileNumber() + " " + tc.getPname());
				Ticket ticket = ticketDao.checkTicket(tc.getGmailId(), tc.getMobileNumber(), tc.getPname());

				if (tc.getDropPoint() != null)
					ticket.setDropPoint(tc.getDropPoint());
				if (tc.getMobileNumber() != null)
					ticket.setMobileNumber(tc.getMobileNumber());
				if (tc.getPickupPoint() != null)
					ticket.setPickupPoint(tc.getPickupPoint());
				if (tc.getPname() != null)
					ticket.setPname(tc.getPname());
				ticket.setUpdate("updated Object");

				Ticket tic = busdao.UpdateSave(ticket);
				if (ticket != null) {
					BookTicket tcDto = new BookTicket();
					Ticket list = tcDto.generate(pc, busdao).get(i);
					TicketDto convertDtoObject = tcDto.convertDtoObject(list, busdao);

					ls.add(convertDtoObject);
				}

			}
			System.out.println("ls" + ls);
			return ls;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new NullPointerException("plse check user data  -");
		}
	}

	@Override
	public void cancleTicket(int id) {
		// TODO Auto-generated method stub
		ticketDao.deleteById(id);

	}

	@Override
	public Ticket getTicketDetails(int tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getallTicket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getallTicketPerticularDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket getAllTicketPerticularBusNUmber(int bid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Bus> getBuses() {

		List<Bus> bus = busdao.getallBus();
		if (bus != null) {
			return bus;
		} else {
			return bus;
		}
		// TODO Auto-generated method stub

	}

	public List<Bus> avlbus() {

		List<Bus> bus = busdao.avlBus();
		if (bus != null) {
			return bus;
		} else {
			return bus;
		}
		// TODO Auto-generated method stub

	}

}
