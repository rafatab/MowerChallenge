package com.seatcode.mowerchallenge.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import com.seatcode.mowerchallenge.domain.Direction;
import com.seatcode.mowerchallenge.domain.Movement;
import com.seatcode.mowerchallenge.domain.Mower;
import com.seatcode.mowerchallenge.domain.Plateau;
import com.seatcode.mowerchallenge.domain.Position;
import com.seatcode.mowerchallenge.domain.exceptions.MowerInvalidDirectionException;
import com.seatcode.mowerchallenge.domain.exceptions.MowerInvalidMovementException;
import com.seatcode.mowerchallenge.domain.exceptions.MowerInvalidPositionException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MowerServiceMapper {

	public MowerCommand fromString(String string)
			throws MowerInvalidDirectionException, MowerInvalidPositionException, MowerInvalidMovementException {
		List<String> lines = Arrays.asList(string.replace("\r", "").split("\n"));

		List<MowerInputs> mowerInputs = retrieveMowersInputs(lines);
		Plateau plateau = parsePlateau(lines.get(0), mowerInputs);
		log.info("Plateau " + plateau);
		return new MowerCommand(plateau, mowerInputs);
	}

	// Helper Methods
	// ----------

	private Plateau parsePlateau(String limitsPlateau, List<MowerInputs> mowerInputs) {

		List<Integer> positionList = Stream.of(limitsPlateau.split(" ")).map(Integer::parseInt).toList();

		List<Mower> convertedMowers = convertInputToMowers(mowerInputs);

		return new Plateau(positionList.get(0), positionList.get(1), convertedMowers);
	}

	private List<MowerInputs> retrieveMowersInputs(List<String> lines) {

		List<MowerInputs> mowerInputs = new ArrayList<>();

		for (int i = 1; i < lines.size(); i = i + 2) {
			String mowerPositionAndDirection = lines.get(i);
			String mowerMovements = lines.get(i + 1);

			MowerInputs mowerInput = retrieveMowerInputs(mowerPositionAndDirection, mowerMovements);
			mowerInputs.add(mowerInput);
			log.info("Mower Initial -> " + i / 2 + " " + mowerInput.getInitialPosition() + " "
					+ mowerInput.getInitialDirection());
		}

		return mowerInputs;
	}

	private MowerInputs retrieveMowerInputs(String mowerPositionAndDirection, String mowerCommands) {
		List<String> positionAndDirection = Stream.of(mowerPositionAndDirection.split(" ")).toList();

		Position initialPosition = getInitialPosition(positionAndDirection);

		Direction initialDirection = getInitialDirection(positionAndDirection);
		
		List<Movement> movementRequests = getMovementRequests(mowerCommands);
		
		return new MowerInputs(initialPosition, initialDirection, movementRequests);

	}

	private List<Mower> convertInputToMowers(List<MowerInputs> mowerInputs) {
		List<Mower> mowers = new ArrayList<>();
		for (MowerInputs mowerInput : mowerInputs)
			mowers.add(new Mower(UUID.randomUUID(), mowerInput.getInitialPosition()));
		return mowers;
	}
	
	private Position getInitialPosition(List <String> positionAndDirection) {
		try {
			return new Position(Integer.parseInt(positionAndDirection.get(0)),
					Integer.parseInt(positionAndDirection.get(1)),
					Direction.valueOf(positionAndDirection.get(2)).getDegrees());
		} catch (NumberFormatException e) {
			throw new MowerInvalidDirectionException(e.getMessage());
		}
	}
	
	private Direction getInitialDirection(List <String> positionAndDirection) {
		try {
			return Direction.valueOf(positionAndDirection.get(2));
		} catch (Exception e) {
			throw new MowerInvalidPositionException(e.getMessage());
		}
	}
	
	private List<Movement> getMovementRequests(String mowerCommands){
		
		try {
			return Stream.of(mowerCommands.split("")).map(Movement::valueOf).toList();
		} catch (Exception e) {
			throw new MowerInvalidMovementException(e.getMessage());
		}
	}
}
