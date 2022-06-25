package com.gdg.gdgbackend.domain.category.entity;

import com.gdg.gdgbackend.domain.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    @Column(nullable = false, length = 200)
    private String categoryMain;

    @Column(length = 200)
    private String categorySub;
}
