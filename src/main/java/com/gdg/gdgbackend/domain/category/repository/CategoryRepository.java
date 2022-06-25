package com.gdg.gdgbackend.domain.category.repository;

import com.gdg.gdgbackend.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByCategoryMain(String categoryMain);
}
