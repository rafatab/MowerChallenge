package com.seatcode.mowerchallenge.domain.exceptions;

public class MowerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MowerNotFoundException(String message) {
		super(message);
	}

}
