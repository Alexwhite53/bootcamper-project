package com.organization.mvcproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.mvcproject.model.Game;

@Service("javaGameService")
public class GameImpl implements GameService {

	private static Long gameId = Long.valueOf(0);
	private static Long companyId = Long.valueOf(0);
	private static List<Game> games = new ArrayList<>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new Game();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new Game();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	@Override
	public List<Game> retrieveAllGames() {
		return games;
	}

	@Override
	public Game saveGame(Game game) {
		game.setId(++gameId);
		games.add(game);
		return game;
	}

	public static Long getGameId() {
		return gameId;
	}

	public static void setId(Long gameId) {
		GameImpl.gameId = gameId;
	}

	public static Long getCompanyId() {
		return companyId;
	}

	public static void setCompanyId(Long companyId) {
		GameImpl.companyId = companyId;
	}

	public static List<Game> getGames() {
		return games;
	}

	public static void setGames(ArrayList<Game> games) {
		GameImpl.games = games;
	}

}