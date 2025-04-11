package org.example.freespace.repository;

import org.example.freespace.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesJpaRepository extends JpaRepository<Categories, Integer> {
    //
}
