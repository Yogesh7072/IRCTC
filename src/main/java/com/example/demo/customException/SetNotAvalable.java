package com.example.demo.customException;

public class SetNotAvalable extends RuntimeException {

	public SetNotAvalable(String sms) {
		super(sms);

	}

}
