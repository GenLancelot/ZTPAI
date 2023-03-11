package com.Teamfinder.service.impl;

import com.Teamfinder.entity.Game;
import com.Teamfinder.repository.GameRepository;
import com.Teamfinder.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Override
    public List<Game> getAllGames(){
        return gameRepository.findAll();
    };
}
