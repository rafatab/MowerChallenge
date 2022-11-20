package com.seatcode.mowerchallenge.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.seatcode.mowerchallenge.domain.Direction;
import com.seatcode.mowerchallenge.domain.MovementHandler;
import com.seatcode.mowerchallenge.domain.Position;
import com.seatcode.mowerchallenge.domain.RightHandler;

public class RightHandlerTest {
	
	@Test
	void testRightHandle() {
		MovementHandler rightHandler = new RightHandler();
		
		Position position = new Position(2,3, Direction.S.getDegrees());
		Position actualPosition = rightHandler.handle(position);
		Position expectedPosition = new Position(2,3,Direction.W.getDegrees());
		
		Assertions.assertEquals(expectedPosition, actualPosition);
	}

}
