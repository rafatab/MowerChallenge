package com.seatcode.mowerchallenge.application;

import java.util.List;

import com.seatcode.mowerchallenge.domain.Direction;
import com.seatcode.mowerchallenge.domain.Movement;
import com.seatcode.mowerchallenge.domain.Position;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MowerInputs {
	private Position initialPosition;
	private Direction initialDirection;
	private List<Movement> mowerMovements;
}
