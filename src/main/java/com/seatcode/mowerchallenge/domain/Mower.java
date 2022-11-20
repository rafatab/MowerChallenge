package com.seatcode.mowerchallenge.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Mower {

	private UUID id;
	private Position position;
	
	public boolean isInPosition(Position position) {
		return this.position.getX() == position.getX() && this.position.getY() == position.getY();
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
