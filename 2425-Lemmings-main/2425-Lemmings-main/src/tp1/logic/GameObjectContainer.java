package tp1.logic;

import java.util.ArrayList;

import tp1.logic.gameobjects.*;

public class GameObjectContainer {
	// Variables

	public ArrayList<Lemming> lemmings;
	public ArrayList<Wall> walls;
	public ArrayList<ExitDoor> exitDoors;

	// Constructor
	public GameObjectContainer() {

		lemmings = new ArrayList<>();
		walls = new ArrayList<>();
		exitDoors = new ArrayList<>();
	}

	// Methods
	public static void update() {
	}

	// Method to add a Lemming to the container
	public void addLemming(Lemming lemming) {
		lemmings.add(lemming);
	}

	public void addWall(Wall wall) {
		walls.add(wall);
	}

	public void addExitDoor(ExitDoor exitDoor) {
		exitDoors.add(exitDoor);
	}

}
