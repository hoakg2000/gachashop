package com.gachashop.shop.service.impl;

import com.gachashop.shop.model.Game;
import com.gachashop.shop.repository.IGameRepository;
import com.gachashop.shop.service.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService implements IGameService {

    @Autowired
    private IGameRepository gameRepository;

    @Override
    public Game getById(long id) {
        Optional<Game> game = gameRepository.findById(id);
        return game.orElse(null);
    }

    @Override
    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game create(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game update(long id, Game updatedGame) {
        Optional<Game> existingGameOptional = gameRepository.findById(id);
        if (existingGameOptional.isPresent()) {
            Game existingGame = existingGameOptional.get();
            existingGame.setName(updatedGame.getName())
                    .setImageUrl(updatedGame.getImageUrl());
            return gameRepository.save(existingGame);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        gameRepository.deleteById(id);
    }
}
