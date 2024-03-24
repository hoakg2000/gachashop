package com.gachashop.shop.controller;

import com.gachashop.shop.model.Game;
import com.gachashop.shop.service.IGameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private IGameService gameService;

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable long id) {
        return gameService.getById(id);
    }

    @GetMapping("/all")
    public List<Game> getAllGames() {
        return gameService.getAll();
    }

    @PostMapping("/create")
    public Game createGame(@Valid @RequestBody Game game) {
        return gameService.create(game);
    }

    @PutMapping("/{id}")
    public Game updateGame(@PathVariable long id, @Valid @RequestBody Game game) {
        return gameService.update(id, game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable long id) {
        gameService.delete(id);
    }
}
