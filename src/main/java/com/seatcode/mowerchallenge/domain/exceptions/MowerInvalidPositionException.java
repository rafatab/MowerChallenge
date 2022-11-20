package com.seatcode.mowerchallenge.domain.exceptions;

public class MowerInvalidPositionException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public MowerInvalidPositionException(String message) {
		super(message);
	}

}
