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

        // should maybe just call canMove and have the memming delegate the move?

        if (lemming.canMove(lemming.getPosition(), lemming.getDirection())) {
            lemming.walkAndFall();
        }
    }

}
