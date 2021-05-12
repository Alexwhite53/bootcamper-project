package com.organization.mvcproject.MGL_Task1.model;

import org.springframework.stereotype.Component;

@Component
public class Game {

	Long gameId;
	String gameName;
	String gameGenre;

	public Long getId() {
		return gameId;
	}

	public void setId(Long gameId) {
		this.gameId = gameId;
	}

	public String getName() {
		return gameName;
	}

	public void setName(String gameName) {
		this.gameName = gameName;
	}

	public String getGenre() {
		return gameGenre;
	}

	public void setGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}

}
