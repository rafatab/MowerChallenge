package com.seatcode.mowerchallenge.domain;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.seatcode.mowerchallenge.domain.Direction;
import com.seatcode.mowerchallenge.domain.Mower;
import com.seatcode.mowerchallenge.domain.Position;

public class MowerTest {
	
	@Test
	void testInPosition() {
		
		Mower mower1 = new Mower(UUID.randomUUID(), new Position(1,4,Direction.N.getDegrees()));
		Mower mower2 = new Mower(UUID.randomUUID(), new Position(1,4,Direction.E.getDegrees()));
		
		Assertions.assertTrue(mower1.isInPosition(mower2.getPosition()));
		
	}
	
	@Test
	void testNotInPosition() {
		
		Mower mower1 = new Mower(UUID.randomUUID(), new Position(1,3,Direction.N.getDegrees()));
		Mower mower2 = new Mower(UUID.randomUUID(), new Position(1,4,Direction.E.getDegrees()));
		
		Assertions.assertFalse(mower1.isInPosition(mower2.getPosition()));
		
	}

}
