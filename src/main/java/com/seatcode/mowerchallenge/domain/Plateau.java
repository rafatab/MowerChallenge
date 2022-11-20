package com.seatcode.mowerchallenge.domain;

import java.util.List;
import java.util.UUID;

import com.seatcode.mowerchallenge.domain.exceptions.MowerNotFoundException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@ToString
@Slf4j
public class Plateau {

	private int xLimit;

	private int yLimit;

	private List<Mower> mowers;

	public void move(UUID mowerId, MovementHandler moveHandler) {
		
		Mower mower = findMowerById(mowerId);
		Position newPosition = moveHandler.handle(mower.getPosition());
		if (isInvalidPosition(newPosition, mowerId)) {
			log.info("Invalid position: Not moving mower");
		} else {
			log.info("Moving mower to new position: "+ newPosition + " "+ Direction.fromDegrees(newPosition.getDegrees()));
			mower.setPosition(newPosition);
		}
	}

	public Mower findMowerById(UUID mowerId) {
		return mowers.stream().filter(m -> m.getId().equals(mowerId)).findAny()
				.orElseThrow(() -> new MowerNotFoundException("Mower with " + mowerId + " not found"));
	}
	
	private boolean isInvalidPosition(Position position, UUID currentMowerId) {
		log.info("Check if movement is out of limit");
		return isOutOfLimits(position) || isAnotherMower(position, currentMowerId);
	}
	
	private boolean isOutOfLimits (Position position) {
		return position.getX() < 0 || position.getY() < 0 || position.getX()> xLimit || position.getY() > yLimit;
	}
	
	private boolean isAnotherMower(Position position, UUID currentMowerId) {
		return mowers.stream().filter(m -> !m.getId().equals(currentMowerId)).anyMatch( m-> m.isInPosition(position));
	}
	
	
}
