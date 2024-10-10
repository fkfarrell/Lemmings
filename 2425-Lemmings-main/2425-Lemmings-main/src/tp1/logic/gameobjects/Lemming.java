package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.WalkerRole;

public class Lemming {

	// TODO fill your code
	private Position position;
	private boolean isAlive;

	public enum direction {
		LEFT, RIGHT, UP, DOWN
	};

	private static int LEFT = 0;
	private static int RIGHT = 1;
	private static int UP = 2;
	private static int DOWN = 3;

	private int forceOfFall;
	private WalkerRole role;
	private Game game;

	public Lemming(Position position, boolean alive, WalkerRole role) {
		this.position = position;
		this.isAlive = alive;
		this.role = role;
	}

	/**
	 * Implements the automatic update
	 */
	public void update() {
		// updates the lemming’s status (falling, dead, or moving).
		// should move left to right
		role.advance(this);

	}

	public Position getPosition() {
		return this.position;
	}

	public void move() {
		Position currentPosition = this.position;
		this.position = new Position(currentPosition.getCol() + 1, currentPosition.getRow());

	}

	// implemend equals method, attribute value should ne the same

}
