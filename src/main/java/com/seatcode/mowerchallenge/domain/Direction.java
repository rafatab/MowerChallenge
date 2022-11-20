package com.seatcode.mowerchallenge.domain;

public enum Direction {

	N(0), E(90), W(270), S(180);
	
	private int degrees;
	
	Direction(int degrees){
		this.degrees = degrees;
	}
	
	
	public static Direction fromDegrees(int degrees) {
		return switch (degrees) {
		case 90 -> E;
		case 0, 360 -> N;
		case 180 -> S;
		case 270 -> W;
		default -> throw new IllegalArgumentException("Cannot handle degrees " + degrees);
		};
	}


	public int getDegrees() {
		return degrees;
	}
	

}
