package com.example.demo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bus {
	@Id
	private int busNumber;
	private String busName;
	private String busStratPint;
	private String busEndPoint;
	private int avlSeat;
	private int allSeat;
	private String busStartTime;
	private String busEndTime;
	private String busRoot;
	@OneToMany
	private List<Ticket> ticket;

	public Bus() {
		super();
	}

	public Bus(int busNumber, String busName, String busStratPint, String busEndPoint, int avlSeat, int allSeat,
			String busStartTime, String busEndTime, String busRoot, List<Ticket> ticket) {
		super();
		this.busNumber = busNumber;
		this.busName = busName;
		this.busStratPint = busStratPint;
		this.busEndPoint = busEndPoint;
		this.avlSeat = avlSeat;
		this.allSeat = allSeat;
		this.busStartTime = busStartTime;
		this.busEndTime = busEndTime;
		this.busRoot = busRoot;
		this.ticket = ticket;
	}

	public int getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusStratPint() {
		return busStratPint;
	}

	public void setBusStratPint(String busStratPint) {
		this.busStratPint = busStratPint;
	}

	public String getBusEndPoint() {
		return busEndPoint;
	}

	public void setBusEndPoint(String busEndPoint) {
		this.busEndPoint = busEndPoint;
	}

	public int getAvlSeat() {
		return avlSeat;
	}

	public void setAvlSeat(int avlSeat) {
		this.avlSeat = avlSeat;
	}

	public int getAllSeat() {
		return allSeat;
	}

	public void setAllSeat(int allSeat) {
		this.allSeat = allSeat;
	}

	public String getBusStartTime() {
		return busStartTime;
	}

	public void setBusStartTime(String busStartTime) {
		this.busStartTime = busStartTime;
	}

	public String getBusEndTime() {
		return busEndTime;
	}

	public void setBusEndTime(String busEndTime) {
		this.busEndTime = busEndTime;
	}

	public String getBusRoot() {
		return busRoot;
	}

	public void setBusRoot(String busRoot) {
		this.busRoot = busRoot;
	}

	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Bus [busNumber=" + busNumber + ", busName=" + busName + ", busStratPint=" + busStratPint
				+ ", busEndPoint=" + busEndPoint + ", avlSeat=" + avlSeat + ", allSeat=" + allSeat + ", busStartTime="
				+ busStartTime + ", busEndTime=" + busEndTime + ", busRoot=" + busRoot + ", ticket=" + ticket + "]";
	}

}
