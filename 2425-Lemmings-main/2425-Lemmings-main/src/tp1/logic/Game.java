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
		Position starterPos = new Position(0, 0);

		switch (nLevel) {
			case 0:
				for (int i = 0; i < 3; i++) {
					container.addLemming(new Lemming(starterPos));
					Position wallPosition = new Position(i, 3);
					container.addWall(new Wall(wallPosition));
					for (int j = 4; j < 8; j++) {
						Position wallPosition2 = new Position(j, 5);
						container.addWall(new Wall(wallPosition2));
					}
				}

				break;
			case 1:
				for (int i = 0; i < 4; i++) {
					container.addLemming(new Lemming(starterPos));
					Position wallPosition = new Position(i, 3);
					container.addWall(new Wall(wallPosition));
					for (int j = 4; j < 8; j++) {
						Position wallPosition2 = new Position(j, 8);
						container.addWall(new Wall(wallPosition2));
					}
					for (int k = 7; k < 10; k++) {
						Position wallPosition2 = new Position(k, 5);
						container.addWall(new Wall(wallPosition2));
					}
				}
				break;
			default:
				for (int i = 0; i < 5; i++) {
					container.addLemming(new Lemming(starterPos));
					Position wallPosition = new Position(i, 2);
					container.addWall(new Wall(wallPosition));
					for (int j = 2; j < 8; j++) {
						Position wallPosition2 = new Position(j, 8);
						container.addWall(new Wall(wallPosition2));
					}
					for (int k = 8; k < 12; k++) {
						Position wallPosition2 = new Position(k, 9);
						container.addWall(new Wall(wallPosition2));
					}
				}
				break;
		}
	}

	public int getCycle() {
		// TODO Auto-generated method stub
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

	// public String positionToString(int col, int row) {

	// Position locale = new Position(col, row);

	// if (locale.toString() != null) {
	// if (locale.toString() == container.exitDoors.get(0).toString()) {
	// return "🚪";
	// } else if (locale.toString() == "WAll") {
	// return "▓";
	// } else
	// return " ";

	// } else {
	// System.out.println("Nothing to see here!");
	// return null;
	// }

	// }

	public String positionToString(int col, int row) {

		Position currentPosition = new Position(col, row);

		// Check for Exit Door
		for (ExitDoor exitDoor : container.exitDoors) {
			if (exitDoor.getPosition().toString().equals(currentPosition.toString())) {
				return "D"; // Exit door representation
			}
		}

		// Check for Walls
		for (Wall wall : container.walls) {
			if (wall.getPosition().equals(currentPosition)) {
				return "W"; // Wall representation
			}
		}

		// Check for Lemmings
		for (Lemming lemming : container.lemmings) {
			if (lemming.getPosition().equals(currentPosition)) {
				return "L"; // Lemming representation
			}
		}

		// If nothing is at this position, return empty space
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
		// TODO Auto-generated method stub
		return null;
	}

}
