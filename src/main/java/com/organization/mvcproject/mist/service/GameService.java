package com.organization.mvcproject.mist.service;

import java.util.List;

import com.organization.mvcproject.mist.model.Game;

public interface GameService {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);

}
