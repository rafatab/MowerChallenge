package com.seatcode.mowerchallenge.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Position {

	private int x;
	private int y;
	private int degrees;
	
	public Position( int x, int y, int degrees) {
		this.x = x;
		this.y = y;
		this.degrees = roundDegrees(degrees);
	}
	
	private int roundDegrees(int degrees) {
		return degrees%360;
	}
}
