package tp1.logic;

import tp1.view.Messages;

/**
 * 
 * Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	private int col;
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

}
