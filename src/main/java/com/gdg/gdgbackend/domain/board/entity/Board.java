package com.gdg.gdgbackend.domain.board.entity;

import com.gdg.gdgbackend.domain.base.BaseEntity;
import com.gdg.gdgbackend.domain.category.entity.Category;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter
@Builder
@AllArgsConstructor
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
    private Integer totalCount;

    @Column(nullable = false)
    private int joinCount;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
