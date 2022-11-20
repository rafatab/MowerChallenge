package com.seatcode.mowerchallenge.application;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.seatcode.mowerchallenge.domain.Direction;
import com.seatcode.mowerchallenge.domain.Movement;
import com.seatcode.mowerchallenge.domain.MovementHandler;
import com.seatcode.mowerchallenge.domain.Mower;
import com.seatcode.mowerchallenge.domain.Plateau;
import com.seatcode.mowerchallenge.domain.Position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MowerService {

	private MowerServiceMapper mapper = new MowerServiceMapper();

	public String executeMowerMovements(String input) {

		MowerCommand command = mapper.fromString(input);

		Plateau plateau = command.getPlateau();
		List<Mower> mowers = plateau.getMowers();
		generateEntries(command.getMowers(), mowers).forEach(e -> moveMower(e.getMovements(), e.getMower(), plateau));
		return toStringResponse(plateau);
	}
	
	// Helper Methods
	// ----------

	private String toStringResponse(Plateau plateau) {

		List<Mower> mowers = plateau.getMowers();
		List<Position> positions = mowers.stream().map(m -> m.getPosition()).toList();
		return positions.stream().map(p -> toStringPosition(p)).reduce("", String::concat);

	}

	private String toStringPosition(Position position) {
		return position.getX() + " " + position.getY() + " " + Direction.fromDegrees(position.getDegrees()).toString()
				+ "\n";
	}

	private List<MowerEntry> generateEntries(List<MowerInputs> mowerInputs, List<Mower> mowers) {
		return IntStream.range(0, mowerInputs.size())
				.mapToObj(i -> new MowerEntry(mowers.get(i), mowerInputs.get(i).getMowerMovements()))
				.collect(Collectors.toList());
	}

	private void moveMower(List<Movement> movements, Mower mower, Plateau plateau) {
		log.info("Moving mower: " + mower.getId());
		movements.stream().forEach(m -> {
			MovementHandler movementHandler = m.executeCommand();
			plateau.move(mower.getId(), movementHandler);
		});
	}

	@Data
	@AllArgsConstructor
	static class MowerEntry {
		private Mower mower;
		private List<Movement> movements;
	}

}
