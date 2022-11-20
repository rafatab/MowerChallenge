package com.seatcode.mowerchallenge.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MowerServiceTest {

	@Test
	void testIntegratedUseCase() {
		MowerService mowerUseCase = new MowerService();

		String input = "5 5\n" + "1 2 N\n" + "LMLMLMLMM\n" + "3 3 E\n" + "MMRMMRMRRM\n";

		String actualOutput = mowerUseCase.executeMowerMovements(input);

		String expectedOutput = "1 3 N\n" + "5 1 E\n";

		Assertions.assertEquals(expectedOutput, actualOutput);
	}

}
