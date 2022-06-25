package com.gdg.gdgbackend.domain.board.repository;

import com.gdg.gdgbackend.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByBoardDateBetween(LocalDateTime start, LocalDateTime end);
    List<Board> findAllByOrdOrderByBoardDateAsc();

}
