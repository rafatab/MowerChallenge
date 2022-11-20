package com.seatcode.mowerchallenge.application;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.seatcode.mowerchallenge.domain.Direction;
import com.seatcode.mowerchallenge.domain.Movement;

public class MowerServiceMapperTest {

	@Test
	void testFromString() {
		MowerServiceMapper mowerMapper = new MowerServiceMapper();

		String input = "5 5\n" + "1 2 N\n" + "LMLMLMLMM\n" + "3 3 E\n" + "MMRMMRMRRM\n";

		MowerCommand mowerCommand = mowerMapper.fromString(input);

		Assertions.assertEquals(mowerCommand.getPlateau().getXLimit(), 5);
		Assertions.assertEquals(mowerCommand.getPlateau().getYLimit(), 5);

		Assertions.assertEquals(mowerCommand.getMowers().get(0).getInitialPosition().getX(), 1);
		Assertions.assertEquals(mowerCommand.getMowers().get(0).getInitialPosition().getY(), 2);
		Assertions.assertEquals(mowerCommand.getMowers().get(0).getInitialPosition().getDegrees(),
				Direction.N.getDegrees());

		Assertions.assertEquals(mowerCommand.getMowers().get(1).getInitialPosition().getX(), 3);
		Assertions.assertEquals(mowerCommand.getMowers().get(1).getInitialPosition().getY(), 3);
		Assertions.assertEquals(mowerCommand.getMowers().get(1).getInitialPosition().getDegrees(),
				Direction.E.getDegrees());
		
		String actualMovements = "";

		List <Movement> movementsMower = mowerCommand.getMowers().get(0).getMowerMovements();
		actualMovements = movementsMower.stream().map(Movement::toString).reduce("",String::concat);
		Assertions.assertEquals( "LMLMLMLMM", actualMovements);
		
		movementsMower = mowerCommand.getMowers().get(1).getMowerMovements();
		actualMovements = movementsMower.stream().map(Movement::toString).reduce("",String::concat);
		Assertions.assertEquals( "MMRMMRMRRM", actualMovements);
	}

}
