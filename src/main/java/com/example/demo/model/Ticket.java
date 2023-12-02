package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.example.demo.Dao.BusDao;
import com.example.demo.dto.TicketDto;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private String mobileNumber;
	private String pname;
	private double payment;
	private String pickupPoint;
	private int seatnumber;
	private String dropPoint;
	private String gmailId;
	@Transient
	private String update;

	@ManyToOne
	private Bus bus;

	public Ticket() {
		super();
	}

	public Ticket(int tid, int seatnumber, String mobileNumber, String pname, double payment, String pickupPoint,
			String dropPoint, Bus bus, String gmailId) {
		super();
		this.tid = tid;
		this.mobileNumber = mobileNumber;
		this.pname = pname;
		this.payment = payment;
		this.pickupPoint = pickupPoint;
		this.dropPoint = dropPoint;
		this.bus = bus;
		this.seatnumber = seatnumber;
		this.gmailId = gmailId;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getGmailId() {
		return gmailId;
	}

	public void setGmailId(String gmailId) {
		this.gmailId = gmailId;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public String getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(String pickupPoint) {
		this.pickupPoint = pickupPoint;
	}

	public String getDropPoint() {
		return dropPoint;
	}

	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public int getSeatnumber() {
		return seatnumber;
	}

	public void setSeatnumber(int seatnumber) {
		this.seatnumber = seatnumber;
	}

	@Override
	public String toString() {
		return "Ticket [tid=" + tid + ", mobileNumber=" + mobileNumber + ", pname=" + pname + ", payment=" + payment
				+ ", pickupPoint=" + pickupPoint + ", seatnumber=" + seatnumber + ", dropPoint=" + dropPoint + ", bus="
				+ bus + "]";
	}

}
