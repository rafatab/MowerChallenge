package com.seatcode.mowerchallenge.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.seatcode.mowerchallenge.domain.Direction;

public class DirectionTest {

	@Test
	void testDirectionNorth() {
		Direction directionActual = Direction.fromDegrees(90);
		Direction directionExpected = Direction.E;

		Assertions.assertEquals(directionExpected , directionActual);

	}

	@Test
	void testDirectionWest() {
		Direction directionActual = Direction.fromDegrees(270);
		Direction directionExpected = Direction.W;

		Assertions.assertEquals(directionExpected, directionActual);
	}

	@Test
	void testDirectionSouth() {
		Direction directionActual = Direction.fromDegrees(180);
		Direction directionExpected = Direction.S;

		Assertions.assertEquals(directionExpected , directionActual);
	}

	@Test
	void testDirectionEast() {
		Direction directionActual = Direction.fromDegrees(90);
		Direction directionExpected = Direction.E;

		Assertions.assertEquals(directionExpected, directionActual);
	}

	@Test
	void testDirectionNorth360() {
		Direction directionActual = Direction.fromDegrees(360);
		Direction directionExpected = Direction.N;

		Assertions.assertEquals(directionExpected, directionActual);
	}

	@Test
	void testDirectionInvalidDegrees() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> Direction.fromDegrees(15));
	}

}
