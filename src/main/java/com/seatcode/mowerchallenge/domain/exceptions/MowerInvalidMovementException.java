package com.seatcode.mowerchallenge.domain.exceptions;

public class MowerInvalidMovementException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MowerInvalidMovementException(String message) {
		super(message);
	}

}
