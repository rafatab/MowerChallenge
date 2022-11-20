package com.seatcode.mowerchallenge.application;

import java.util.List;

import com.seatcode.mowerchallenge.domain.Plateau;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MowerCommand {
	private Plateau plateau;
	private List<MowerInputs> mowers;
}
