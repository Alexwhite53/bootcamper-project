package com.organization.mvcproject.DAO;

import java.util.List;

import com.organization.mvcproject.model.Game;

public interface GameDAO {
	List<Game> retrieveAllGames();

	Game saveGame(Game game);


}
