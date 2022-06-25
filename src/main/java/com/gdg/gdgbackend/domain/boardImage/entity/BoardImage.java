package com.gdg.gdgbackend.domain.boardImage.entity;

import com.gdg.gdgbackend.domain.base.BaseEntity;
import com.gdg.gdgbackend.domain.board.entity.Board;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "board_image")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardImageId;

    @Column(nullable = false, length = 500)
    private String boardImageName;

    @Column(nullable = false, length = 500)
    private String boardImageUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;


    @Builder
    public BoardImage(String boardImageName, String boardImageUrl, Board board) {
        this.boardImageName = boardImageName;
        this.boardImageUrl = boardImageUrl;
        this.board = board;
    }

    public static BoardImage createBoardImage(BoardImage boardImage, Board board) {
        return BoardImage.builder()
                .boardImageName(boardImage.getBoardImageName())
                .boardImageUrl(boardImage.getBoardImageUrl())
                .board(board)
                .build();
    }

    public void updateItemImage(String boardImageName, String boardImageUrl) {
        this.boardImageName = boardImageName;
        this.boardImageUrl = boardImageUrl;
    }

    public void initImageInfo() {
        this.boardImageName = "";
        this.boardImageUrl = "";
    }
}
