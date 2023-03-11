package com.Teamfinder.repository;

import com.Teamfinder.entity.Game;
import com.Teamfinder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findById(Long ID_Game);
}
