package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameObjectContainer;
import tp1.logic.Position;
import tp1.logic.WalkerRole;
import tp1.logic.Direction;

public class Lemming extends GameObjectContainer {

	// TODO fill your code
	private Position position;
	public boolean isAlive;
	private int forceOfFall;
	private WalkerRole role;
	private Game game;
	public Direction dir;
	public boolean exited;
	private GameObjectContainer container;

	public Lemming(Position position, boolean alive, WalkerRole role, Direction dir, Game game, boolean exited) {
		this.position = position;
		this.isAlive = alive;
		this.role = role;
		this.dir = dir;
		this.game = game;
		this.forceOfFall = forceOfFall;
	}

	/**
	 * Implements the automatic update
	 */
	public void update() {
		// updates the lemming’s status (falling, dead, or moving).
		if (isAlive) {
			role.advance(this);
			if (dir == Direction.DOWN) {
				forceOfFall++;
			}
		}
		if (forceOfFall > 3) {
			this.isAlive = false;
		}

	}

	public Position getPosition() {
		return this.position;
	}

	public Direction getDirection() {
		return this.dir;
	}

	public boolean canMove(Position pos, Direction dir) {
		int moveX = this.position.getCol() + dir.getX();
		int moveY = this.position.getRow() + dir.getY();

		// Check if there's a floor beneath the lemming
		if (game.positionToString(pos.getCol(), pos.getRow() + 1).equals("▓")) {
			// If there's a floor, check if the next position is a wall

			// this.dir = Direction.RIGHT;

			this.forceOfFall = 0;
			if (moveX == 0 || moveX == 10) {
				this.reverseDir();
			}

			if (game.positionToString(moveX, moveY).equals("▓")) {
				this.reverseDir();
				return false;
			} else {
				return true;
			}
		} else {
			// If there's no floor, change direction
			this.dir = Direction.DOWN;
			return true;
		}
	}

	public void walkAndFall() {
		int moveX = this.position.getCol() + dir.getX();
		int moveY = this.position.getRow() + dir.getY();

		// Check if the lemming has reached the bottom of the board
		if (moveY < Game.DIM_Y) {
			this.position = new Position(moveX, moveY);

			// handle exit
			for (ExitDoor exitDoor : game.container.exitDoors) {
				if (exitDoor.getPosition().equals(this.position)) {
					this.exited = true;
					// this.position = new Position(12, 12);
					// container.lemmings.remove(position.toString());
					this.dir = Direction.NONE;
				}
			}

		} else {
			// If the lemming has reached the bottom, stop it from falling further
			this.dir = Direction.RIGHT;
		}

		if (this.forceOfFall > Game.MAX_FALL || (moveY >= 9)) {
			this.isAlive = false;
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
