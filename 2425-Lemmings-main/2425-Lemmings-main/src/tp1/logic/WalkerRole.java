package tp1.logic;

import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public class WalkerRole {

    private GameObjectContainer container;

    // Constructor that takes the container from Game class
    public WalkerRole(GameObjectContainer container) {
        this.container = container;
    }

    public void advance(Lemming lemming) {
        // responsible for the lemming’s movement
        // behavior. Calls the move() method in the Lemming class.

        // lemming.walk();
        if (lemming.canMove(lemming.getPosition(), lemming.getDirection())) {
            lemming.walk();
        }

    }

}
