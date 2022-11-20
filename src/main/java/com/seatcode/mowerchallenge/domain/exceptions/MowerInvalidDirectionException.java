package com.seatcode.mowerchallenge.domain.exceptions;

public class MowerInvalidDirectionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MowerInvalidDirectionException(String message) {
		super(message);
	}

}
