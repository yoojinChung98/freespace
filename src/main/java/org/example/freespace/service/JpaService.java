package org.example.freespace.service;

import lombok.RequiredArgsConstructor;
import org.example.freespace.entity.Categories;
import org.example.freespace.entity.Products;
import org.example.freespace.repository.CategoriesJpaRepository;
import org.example.freespace.repository.ProductsJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaService {
    private final ProductsJpaRepository productsJpaRepository;
    private final CategoriesJpaRepository categoriesJpaRepository;

    public List<Products> retrieveAllProducts () {
        List<Products> products = productsJpaRepository.findAll();
        return products;
    }

    public List<Categories> retrieveAllCategories () {
        List<Categories> categories = categoriesJpaRepository.findAll();
        return categories;
    }
}
