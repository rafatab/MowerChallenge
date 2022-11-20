package com.seatcode.mowerchallenge.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.seatcode.mowerchallenge.domain.Direction;
import com.seatcode.mowerchallenge.domain.LeftHandler;
import com.seatcode.mowerchallenge.domain.MovementHandler;
import com.seatcode.mowerchallenge.domain.Position;

public class LeftHandlerTest {

	@Test
	void testLeftHandle() {
		MovementHandler leftHandler = new LeftHandler();
		
		Position position = new Position(1,2,Direction.N.getDegrees());
		Position actualPosition = leftHandler.handle(position);
		Position expectedPosition = new Position(1,2,Direction.W.getDegrees());
		
		Assertions.assertEquals(expectedPosition, actualPosition);
		
	}

}
