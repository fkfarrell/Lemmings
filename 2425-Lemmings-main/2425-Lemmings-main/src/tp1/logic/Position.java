package tp1.logic;

import java.util.Objects;

import tp1.view.Messages;

/**
 * 
 * Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	private final int COL=0;
	private int row;

	// TODO fill your code

	// Constructor to initialize the position
	public Position(int col, int row) {
		if (col < 0 || col >= 10 || row < 0 || row >= 10) {
			System.out.print(Messages.INVALID_POSITION);
		}
		this.col = col;
		this.row = row;
	}

	// Getter for column
	public int getCol() {
		return col;
	}

	// Getter for row
	public int getRow() {
		return row;
	}

	@Override
	public boolean equals(Object obj) {
		// Check if the object being compared is the same instance
		if (this == obj) {
			return true;
		}

		// Check if the object is null or not the same class
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		// Cast the object to a Position and compare the fields
		Position other = (Position) obj;
		return this.col == other.col && this.row == other.row;
	}

	@Override
	public String toString() {
		return "(" + col + "," + row + ")";
	}

}
