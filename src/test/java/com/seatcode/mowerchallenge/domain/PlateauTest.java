package com.seatcode.mowerchallenge.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.seatcode.mowerchallenge.domain.Direction;
import com.seatcode.mowerchallenge.domain.MoveHandler;
import com.seatcode.mowerchallenge.domain.MovementHandler;
import com.seatcode.mowerchallenge.domain.Mower;
import com.seatcode.mowerchallenge.domain.Plateau;
import com.seatcode.mowerchallenge.domain.Position;
import com.seatcode.mowerchallenge.domain.exceptions.MowerNotFoundException;

public class PlateauTest {

	@Test
	void testMove() {
		Mower mower = new Mower(UUID.randomUUID(), new Position(1, 2, Direction.N.getDegrees()));
		Plateau plateau = new Plateau(5, 5, List.of(mower));

		MovementHandler moveHandler = new MoveHandler();

		Position expectedPosition = moveHandler.handle(mower.getPosition());

		plateau.move(mower.getId(), moveHandler);

		Mower updatedMower = plateau.findMowerById(mower.getId());

		Assertions.assertEquals(expectedPosition, updatedMower.getPosition());
	}

	@Test
	void testNotMoveWhenOutOfPlateau() {

		MovementHandler moveHandler = new MoveHandler();
		Mower mower1 = new Mower(UUID.randomUUID(), new Position(5, 5, Direction.E.getDegrees()));
		Plateau plateau1 = new Plateau(5, 5, List.of(mower1));

		plateau1.move(mower1.getId(), moveHandler);

		Mower updatedMower = plateau1.findMowerById(mower1.getId());

		Assertions.assertEquals(mower1.getPosition(), updatedMower.getPosition());

		Mower mower2 = new Mower(UUID.randomUUID(), new Position(3, 5, Direction.N.getDegrees()));
		Plateau plateau2 = new Plateau(5, 5, List.of(mower2));

		plateau2.move(mower2.getId(), moveHandler);

		updatedMower = plateau2.findMowerById(mower2.getId());

		Assertions.assertEquals(mower2.getPosition(), updatedMower.getPosition());
		
		Mower mower3 = new Mower(UUID.randomUUID(), new Position(1, 0, Direction.S.getDegrees()));
		Plateau plateau3 = new Plateau(5, 5, List.of(mower3));

		plateau3.move(mower3.getId(), moveHandler);

		updatedMower = plateau3.findMowerById(mower3.getId());

		Assertions.assertEquals(mower3.getPosition(), updatedMower.getPosition());
		
		Mower mower4 = new Mower(UUID.randomUUID(), new Position(0, 1, Direction.W.getDegrees()));
		Plateau plateau4 = new Plateau(5, 5, List.of(mower4));

		plateau4.move(mower4.getId(), moveHandler);

		updatedMower = plateau4.findMowerById(mower4.getId());

		Assertions.assertEquals(mower4.getPosition(), updatedMower.getPosition());

	}

	@Test
	void testNotMovewWhenPositionOccupied() {
		Mower mower1 = new Mower(UUID.randomUUID(), new Position(1, 2, Direction.N.getDegrees()));
		Mower mower2 = new Mower(UUID.randomUUID(), new Position(2, 2, Direction.W.getDegrees()));
		Plateau plateau = new Plateau(5, 5, List.of(mower1, mower2));

		MovementHandler moveHandler = new MoveHandler();

		plateau.move(mower2.getId(), moveHandler);

		Mower updatedMower = plateau.findMowerById(mower2.getId());

		Assertions.assertEquals(mower2.getPosition(), updatedMower.getPosition());
	}

	@Test
	void testMowerNotFoundException() {

		Mower mower = new Mower(UUID.randomUUID(), new Position(3, 4, Direction.S.getDegrees()));
		Plateau plateau = new Plateau(5, 5, List.of(mower));
		RuntimeException mowerNotFound = assertThrows(MowerNotFoundException.class,
				() -> plateau.findMowerById(UUID.randomUUID()));
		String mowerNotFoundMessage = mowerNotFound.getMessage();

		Assertions.assertTrue(mowerNotFoundMessage.contains("not found"));

	}

}
