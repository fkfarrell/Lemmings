package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public class Game {

	// view asks game game asks container

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;

	public int cycleNum = 0;
	public static final int MAX_FALL = 3;

	public GameObjectContainer container = new GameObjectContainer();
	private int currentLvl = 0;
	public boolean gameRunning = true;
	private int initialLvl;

	public boolean playerWins = false;

	public Game(int nLevel) {
		nLevel = currentLvl;
		this.initialLvl = nLevel;
		LevelStarter.initializeGame(this, this.initialLvl);
		currentLvl++;

	}

	public int getCycle() {
		return cycleNum;
	}

	public int numLemmingsInBoard() {
		int numLemmings = container.lemmings.size();
		int calc = numLemmings - (numLemmingsDead() + numLemmingsExit());
		return calc;
	}

	public int numLemmingsDead() {
		int deadLemmingCount = 0;
		for (Lemming lemming : container.lemmings) {
			if (!lemming.isAlive) {
				deadLemmingCount++;
			}
		}
		return deadLemmingCount;
	}

	public int numLemmingsExit() {
		int exitedLemmings = 0;
		for (Lemming lemming : container.lemmings) {
			if (lemming.exited) {
				exitedLemmings++;
			}
			if (exitedLemmings == numLemmingsToWin()) {
				this.playerWins();
			}
		}
		return exitedLemmings;
	}

	public int numLemmingsToWin() {
		// TODO Auto-generated method stub
		int numLemmingsToWin = currentLvl;
		return numLemmingsToWin;
	}

	public String positionToString(int col, int row) {

		Position currentPosition = new Position(col, row);

		// Check for Exit Door
		for (ExitDoor exitDoor : container.exitDoors) {
			if (exitDoor.getPosition().equals(currentPosition)) {
				return "X"; // replace with 🚪 in ecplise
			}
		}

		// Check for Walls
		for (Wall wall : container.walls) {
			if (wall.getPosition().equals(currentPosition)) {
				return "▓";
			}
		}

		// Check for Lemmings
		for (Lemming lemming : container.lemmings) {
			if (lemming.getPosition().equals(currentPosition)) {

				if (lemming.getDirection().toString() == "RIGHT" || lemming.getDirection().toString() == "DOWN") {
					return "b";
				} else {
					return "d";
				}
			}

		}
		return " ";
	}

	public void playerWins() {
		playerWins = true;
	}

	public boolean playerLooses() {
		if (numLemmingsDead() == numLemmingsExit()) {
			return true;
		}
		return false;
	}

	public String help() {

		String helpText = "Available commands:\n" +
				"[r]eset: start a new game\n" +
				"[h]elp: print this help message\n" +
				"[e]xit: end the execution of the game\n" +
				"[n]one | \"\": skip a cycle";

		return helpText;
	}

	public void reset() {
		LevelStarter.initializeGame(this, initialLvl);
	}

	public void exit() {
		// Exits the game after displaying the message Player leaves game.
		gameRunning = false;
	}

	public void none() {
		container.update();
	}

}
