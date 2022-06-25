package com.gdg.gdgbackend.domain.board.entity;

import com.gdg.gdgbackend.domain.base.BaseEntity;
import com.gdg.gdgbackend.domain.boardImage.entity.BoardImage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardId;

    @Column(nullable = false, length = 200)
    private String boardTitle;

    @Column(nullable = false)
    private LocalDateTime boardDate;

    @Column(nullable = false, length = 250)
    private String boardLocation;

    @Lob
    @Column(nullable = false)
    private String boardContent;

    @Column(nullable = false, length = 500)
    private String boardImageName;

    @Column(nullable = false, length = 500)
    private String boardImageUrl;

    @Column(nullable = false)
    private int totalCount;

    @Column(nullable = false)
    private int joinCount;

}
