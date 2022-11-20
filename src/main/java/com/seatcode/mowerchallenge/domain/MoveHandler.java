package com.seatcode.mowerchallenge.domain;

public class MoveHandler implements MovementHandler {

	@Override
	public Position handle(Position position) {
		return switch (position.getDegrees()) {
		case 90 -> new Position(position.getX() + 1, position.getY(), position.getDegrees());
		case 0, 360 -> new Position(position.getX(), position.getY() + 1, position.getDegrees());
		case 180 -> new Position(position.getX() , position.getY() - 1, position.getDegrees());
		case 270 -> new Position(position.getX() - 1, position.getY() , position.getDegrees());
		default -> throw new IllegalArgumentException("Cannot handle degrees " + position.getDegrees());
		};

	}

}
