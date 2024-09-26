package tp1;

import java.util.Locale;

import tp1.control.Controller;
import tp1.logic.Game;
import tp1.view.ConsoleColorsView;
import tp1.view.ConsoleView;
import tp1.view.GameView;
import tp1.view.Messages;

public class Main {
	//KATE TESTING
	/**
	 * Lemmings entry point
	 * 
	 * @param args Arguments for the game.
	 */
	public static void main(String[] args) {
		// Required to avoid issues with tests
		// Locale.of("es", "ES");
		// You can replace the following line by the previous line if using Java21
		Locale.setDefault(new Locale("es", "ES"));
		try {
			
			int nLevel = 1;
			if (args.length != 0) nLevel = Integer.parseInt(args[0]);

			Game game = new Game(nLevel);
			GameView view = new ConsoleView(game);
			Controller controller = new Controller(game, view);
					
			controller.run();
		} catch (NumberFormatException e) {
			System.out.println(String.format(Messages.LEVEL_NOT_A_NUMBER_ERROR, args[0]));
		}
	}
}
