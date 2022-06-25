package com.gdg.gdgbackend.domain.board.repository;

import com.gdg.gdgbackend.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByBoardDateBetween(LocalDateTime start, LocalDateTime end);

    List<Board> findAllByOrderByBoardDateAsc();

    @Query("SELECT COUNT(b) FROM Board b WHERE b.boardDate BETWEEN :start_date AND :end_date")
    long getCount(@Param("start_date") LocalDateTime startDate,
                  @Param("end_date") LocalDateTime endDate);
}
