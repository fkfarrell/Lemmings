package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public class Game {

	// view asks game game asks container

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;

	public static int cycleNum = 0;
	public static final int MAX_FALL = 3;

	public GameObjectContainer container = new GameObjectContainer();

	public Game(int nLevel) {

		// divide levels here
		Position doorPosition = new Position(9, 9);
		ExitDoor newDoor = new ExitDoor(doorPosition);
		container.exitDoors.add(newDoor);

		switch (nLevel) {
			case 0:
				// Add lemmings, walls and exit door. <<<<<<<<<<<<<<<< does this work ?

				for (int i = 0; i < 3; i++) {
					Lemming newLemming = new Lemming();
					container.addLemming(newLemming);
				}
				// add walls to the gameObjectConatainer
				Wall newWall = new Wall(null); // walls need position param, in what form is position??
				container.addWall(newWall);

				break;
			case 1:
				for (int i = 0; i < 4; i++) {
					Lemming newLemming = new Lemming();
					container.addLemming(newLemming);
				}
				break;
			default:
				for (int i = 0; i < 5; i++) {
					Lemming newLemming = new Lemming();
					container.addLemming(newLemming);
				}
				break;
		}
	}

	public int getCycle() {
		// TODO Auto-generated method stub
		return cycleNum;
	}

	public int numLemmingsInBoard() {
		// TODO Auto-generated method stub
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

		Position locale = new Position(col, row);
		System.out.println("what is a locale.toString " + container.exitDoors.get(0).toString());
		if (locale.toString() != null) {
			if (locale.toString() == container.exitDoors.get(0).toString()) {
				return "🚪";
			} else if (locale.toString() == "▓") {
				return "▓";
			} else
				return " ";

		} else {
			System.out.println("Nothing to see here!");
			return null;
		}

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
		// TODO Auto-generated method stub
		return null;
	}

}
