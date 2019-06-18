package game.dice.com.dicegameapp.application;

import java.util.List;
import game.dice.com.dicegameapp.domain.*;


public class GameController {

	private Player player;


	public GameController() {

	}

	public void createPlayer(String name) {
		this.player = new Player(name);
	}

	public String getPlayerName() {
		return player.getName();
	}


	//mètode propi
	public void setPlayerName(String string) {
		this.player.setName(string);
	}

	//reescric el playGame, per poder obtenir més dades del joc en la pantalla
/*	public boolean playGame() {
		Game game = new Game();
		boolean hasWon = game.playGame();
		player.addGame(game);
		return hasWon;
	}*/


	public boolean playGame(Game game) {
	//	Game game = new Game();
		boolean hasWon = game.playGame();
		player.addGame(game);
		return hasWon;
	}

	//modificat per mostrar més dades a la pantalla
	public String getPlayerGamesToString() {
		String text = "";
		List<Game> games = player.getAllGames();

		for (int i = 0; i < games.size(); i++) {
			text += "Game " + (i +1) + ": " +
					"dice1= " + games.get(i).getDice1Value() + ", " +
					"dice2= " + games.get(i).getDice2Value() + ", " +
					"total= " + games.get(i).getSumDices() + "\n";
		}
		return text;
	}

	public double getPlayerRanking() {
		List<Game> games = player.getAllGames();

		double wins = 0.0;
		for (Game game : games) {
			if (game.hasWon())
				wins++;
		}
		return wins / games.size();
	}

}
