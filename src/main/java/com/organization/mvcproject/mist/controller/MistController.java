package com.organization.mvcproject.mist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.mist.model.Game;
import com.organization.mvcproject.mist.model.Review;
import com.organization.mvcproject.mist.service.GameService;


@Controller
public class MistController {

	@Autowired
	private GameService javaGameService;

	@GetMapping(value = "/")
	public String home() {
		return "index";
	}

	@GetMapping(value = "/review")
	public ModelAndView review() {
		return new ModelAndView("review", "command", new Review());
	}

	@GetMapping(value = "/addReview")
	public ModelAndView addReview(Review review, ModelMap model) {
		if(review.getAuthor().equals("")) {
			review.setAuthor("anonymous");
		}
		return new ModelAndView("result", "submittedReview", review);
	}

	@GetMapping(value = "/games")
	public ModelAndView game() {
		return new ModelAndView("games", "command", new Game());
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(javaGameService.retrieveAllGames(), HttpStatus.OK);
	}

	@PostMapping(value = "/createGame", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody Game game) {
		javaGameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}