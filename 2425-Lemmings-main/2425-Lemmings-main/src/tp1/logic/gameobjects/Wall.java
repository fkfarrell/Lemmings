package tp1.logic.gameobjects;

import tp1.logic.Position;

public class Wall {
    private Position position;
    private String wallSprite = "▓";

    public Wall(Position position) {
        this.position = position;
        wallSprite = position.toString();
    }

    public Position getPosition() {
        return this.position;
    }

    public String toString() {
        return wallSprite;
    }

    public void update() {

    }
}
