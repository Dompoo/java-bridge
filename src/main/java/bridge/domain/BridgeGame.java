package bridge.domain;

import bridge.common.dto.GameResult;
import bridge.common.dto.MoveResult;
import bridge.common.dto.StepResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BridgeGame {
	
	private final Bridge bridge;
	private final List<StepResult> stepResults = new ArrayList<>();
	private int currentPosition = 0;
	private int tryCount = 1;
	
	public BridgeGame(Bridge bridge) {
		Objects.requireNonNull(bridge);
		this.bridge = bridge;
	}
	
	public MoveResult move(MoveCommand moveCommand) {
		stepResults.add(bridge.move(currentPosition++, moveCommand));
		return new MoveResult(stepResults);
	}
	
	public boolean isBridgeGameSuccess() {
		return bridge.isBridgeEnd(currentPosition);
	}
	
	public boolean restart(RestartCommand restartCommand) {
		if (restartCommand.isEnd()) {
			return false;
		}
		currentPosition = 0;
		tryCount++;
		stepResults.clear();
		return true;
	}
	
	public GameResult getGameResult() {
		return new GameResult(new MoveResult(stepResults), tryCount);
	}
}
