package com.seatcode.mowerchallenge.domain;

public class LeftHandler implements MovementHandler {

	@Override
	public Position handle(Position position) {
		return new Position(position.getX(), position.getY(), position.getDegrees() +270);
	}

}
