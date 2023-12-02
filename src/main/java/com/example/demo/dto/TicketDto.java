package com.example.demo.dto;

import javax.persistence.Id;

public class TicketDto {
	@Id
	private int tid;
	private String mobileNumber;
	private String pname;
	private double payment;
	private String pickupPoint;
	private String dropPoint;
	private int busNumber;
	private int seatnumber;
	private String busName;
	private String busStratPint;
	private String busEndPoint;
	private String busStartTime;
	private String busEndTime;
	private String busRoot;

	public TicketDto() {
		super();
	}

	public TicketDto(int tid, int seatnumber, String mobileNumber, String pname, double payment, String pickupPoint,
			String dropPoint, int busNumber, String busName, String busStratPint, String busEndPoint,
			String busStartTime, String busEndTime, String busRoot) {
		super();
		this.tid = tid;
		this.mobileNumber = mobileNumber;
		this.pname = pname;
		this.payment = payment;
		this.pickupPoint = pickupPoint;
		this.dropPoint = dropPoint;
		this.busNumber = busNumber;
		this.busName = busName;
		this.busStratPint = busStratPint;
		this.busEndPoint = busEndPoint;
		this.busStartTime = busStartTime;
		this.busEndTime = busEndTime;
		this.busRoot = busRoot;
		this.seatnumber = seatnumber;
	}

	public int getSeatnumber() {
		return seatnumber;
	}

	public void setSeatnumber(int seatnumber) {
		this.seatnumber = seatnumber;
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

	@Override
	public String toString() {
		return "TicketDto [tid=" + tid + ", mobileNumber=" + mobileNumber + ", pname=" + pname + ", payment=" + payment
				+ ", pickupPoint=" + pickupPoint + ", dropPoint=" + dropPoint + ", busNumber=" + busNumber
				+ ", seatnumber=" + seatnumber + ", busName=" + busName + ", busStratPint=" + busStratPint
				+ ", busEndPoint=" + busEndPoint + ", busStartTime=" + busStartTime + ", busEndTime=" + busEndTime
				+ ", busRoot=" + busRoot + "]";
	}

}
