package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import java.util.ArrayList; 


public class GameObjectContainer {
	//list of objects
	ArrayList<Lemming> lemmingsList = new ArrayList<Lemming>();
	ArrayList<Wall> wallsList = new ArrayList<Wall>();
	ArrayList<ExitDoor> exitDoorsList = new ArrayList<ExitDoor>();

	public void add(Lemming lemming) {
		lemmingsList.add(lemming);
	}

    public void add(Wall wall) {
		wallsList.add(wall);
	}

	public void add(ExitDoor exitDoor) {
		exitDoorsList.add(exitDoor);
	}


}
