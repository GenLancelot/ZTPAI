package com.Teamfinder.controller;


import com.Teamfinder.controller.configuration.Converter;
import com.Teamfinder.controller.dto.GameDto;
import com.Teamfinder.service.GameService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class GameController {

    private final GameService gamesService;
    private final Converter converter;
    public static final String GAMES_FETCHED_SUCCESSFULLY = "Games fetched successfully";

    @GetMapping("/gameselect")
    public ResponseEntity<List<GameDto>> getMatches() {
        List<GameDto> gameDtos;
        try {
            gameDtos = converter
                    .convertList(gamesService.getAllGames(), GameDto.class);
        } catch (EntityNotFoundException entityNotFoundException) {
            log.error(entityNotFoundException.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        log.info(GAMES_FETCHED_SUCCESSFULLY);
        return new ResponseEntity<>(gameDtos, HttpStatus.OK);
    }

}
