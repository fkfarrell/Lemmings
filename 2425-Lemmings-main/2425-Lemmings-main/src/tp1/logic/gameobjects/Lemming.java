package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameObjectContainer;
import tp1.logic.Position;
import tp1.logic.WalkerRole;
import tp1.logic.Direction;

public class Lemming extends GameObjectContainer {

	// TODO fill your code
	private Position position;
	private boolean isAlive;
	private int forceOfFall;
	private WalkerRole role;
	private Game game;
	public Direction dir;
	private GameObjectContainer container;

	public Lemming(Position position, boolean alive, WalkerRole role, Direction dir, Game game) {
		this.position = position;
		this.isAlive = alive;
		this.role = role;
		this.dir = dir;
		this.game = game;
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

	public Direction getDirection() {
		return this.dir;
	}

	public boolean canMove(Position pos, Direction dir) {
		// check whether the move can be made in a given directoin.

		int moveX = this.position.getCol() + dir.getX();
		int moveY = this.position.getRow() + dir.getY();

		if (game.positionToString(moveX, moveY) == "▓") {
			this.reverseDir();
			return false;
		} else if (moveX == 0 || moveX == 10) {
			this.reverseDir();
			return false;
		} else {
			return true;
		}

	}

	public void walk() {
		int moveX = this.position.getCol() + dir.getX();
		int moveY = this.position.getRow() + dir.getY();
		if (this.canMove(this.position, this.dir)) {

			Position currentPosition = this.position;
			this.position = new Position(moveX, moveY);
		}
	}

	private void reverseDir() {
		if (dir == Direction.RIGHT) {
			dir = Direction.LEFT;
		} else {
			dir = Direction.RIGHT;
		}
	}

	// implemend equals method, attribute value should ne the same

}
