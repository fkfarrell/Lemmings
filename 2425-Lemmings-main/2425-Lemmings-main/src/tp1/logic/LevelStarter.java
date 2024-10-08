package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public class LevelStarter {

    public static void initializeGame(Game game, int nLevel) {
        game.cycleNum = 0;
        game.container = new GameObjectContainer();

        final int DOOR_ROW = 9;
        final int DOOR_COL = 10;

        Position doorPosition = new Position(DOOR_COL, DOOR_ROW);
        ExitDoor newDoor = new ExitDoor(doorPosition);
        game.container.exitDoors.add(newDoor);
        WalkerRole walker = new WalkerRole(game.container);

        switch (nLevel) {
            case 0:
                Position[] lemmingPositionsLevel0 = {
                        new Position(1, 1),
                        new Position(2, 2),
                        new Position(3, 3)
                };
                for (int i = 0; i < lemmingPositionsLevel0.length; i++) {
                    Position lemmingPos = lemmingPositionsLevel0[i];
                    game.container.addLemming(new Lemming(lemmingPos, true, walker));

                    Position wallPosition = new Position(i, 3);
                    game.container.addWall(new Wall(wallPosition));

                    for (int j = 4; j < 8; j++) {
                        Position wallPosition2 = new Position(j, 5);
                        game.container.addWall(new Wall(wallPosition2));
                    }
                }
                break;
            case 1:
                Position[] lemmingPositionsLevel1 = {
                        new Position(0, 0),
                        new Position(3, 1),
                        new Position(5, 2),
                        new Position(7, 3)
                };
                for (int i = 0; i < lemmingPositionsLevel1.length; i++) {
                    Position lemmingPos = lemmingPositionsLevel1[i];
                    game.container.addLemming(new Lemming(lemmingPos, true, walker));

                    Position wallPosition = new Position(i, 3);
                    game.container.addWall(new Wall(wallPosition));

                    for (int j = 4; j < 8; j++) {
                        Position wallPosition2 = new Position(j, 8);
                        game.container.addWall(new Wall(wallPosition2));
                    }
                    for (int k = 7; k < 10; k++) {
                        Position wallPosition2 = new Position(k, 5);
                        game.container.addWall(new Wall(wallPosition2));
                    }
                }
                break;
            default:
                Position[] lemmingPositionsDefault = {
                        new Position(4, 4),
                        new Position(6, 6),
                        new Position(8, 8),
                        new Position(2, 7),
                        new Position(1, 9)
                };
                for (int i = 0; i < lemmingPositionsDefault.length; i++) {
                    Position lemmingPos = lemmingPositionsDefault[i];
                    game.container.addLemming(new Lemming(lemmingPos, true, walker));

                    Position wallPosition = new Position(i, 2);
                    game.container.addWall(new Wall(wallPosition));

                    for (int j = 2; j < 8; j++) {
                        Position wallPosition2 = new Position(j, 8);
                        game.container.addWall(new Wall(wallPosition2));
                    }
                    for (int k = 8; k < 12; k++) {
                        Position wallPosition2 = new Position(k, 9);
                        game.container.addWall(new Wall(wallPosition2));
                    }
                }
                break;
        }
    }
}
