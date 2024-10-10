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
	private int currentLvl;
	public boolean gameRunning = true;
	private int initialLvl;

	public Game(int nLevel) {
		this.initialLvl = nLevel;
		LevelStarter.initializeGame(this, nLevel);

	}

	public int getCycle() {
		return cycleNum;
	}

	public int numLemmingsInBoard() {
		int numLemmings = container.lemmings.size();
		return numLemmings;
	}

	public int numLemmingsDead() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numLemmingsExit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numLemmingsToWin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String positionToString(int col, int row) {

		Position currentPosition = new Position(col, row);

		// Check for Exit Door
		for (ExitDoor exitDoor : container.exitDoors) {
			if (exitDoor.getPosition().toString().equals(currentPosition.toString())) {
				return "🚪";
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
				return "B"; // Lemming representation
				// should be backwards if the lemming is moving right to left
			}
		}
		return " ";
	}

	public boolean playerWins() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean playerLooses() {
		// TODO Auto-generated method stub
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
