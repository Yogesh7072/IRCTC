package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


public class PassangerDetails {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private String gmailId;
	private String mobileNumber;
	private String pickupPoint;
	private String busname;
	private String dropPoint;

	public PassangerDetails() {
		super();
	}

	public PassangerDetails(int pid, String busname, String pname, String gmailId, String mobileNumber,
			String pickupPoint, String dropPoint) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.gmailId = gmailId;
		this.mobileNumber = mobileNumber;
		this.pickupPoint = pickupPoint;
		this.dropPoint = dropPoint;
		this.busname = busname;
	}

	public String getBusname() {
		return busname;
	}

	public void setBusname(String busname) {
		this.busname = busname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getGmailId() {
		return gmailId;
	}

	public void setGmailId(String gmailId) {
		this.gmailId = gmailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	@Override
	public String toString() {
		return "PassangerDetails [pid=" + pid + ", pname=" + pname + ", gmailId=" + gmailId + ", mobileNumber="
				+ mobileNumber + ", pickupPoint=" + pickupPoint + ", busname=" + busname + ", dropPoint=" + dropPoint
				+ "]";
	}

}
