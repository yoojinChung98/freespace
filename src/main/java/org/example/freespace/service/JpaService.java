package org.example.freespace.service;

import lombok.RequiredArgsConstructor;
import org.example.freespace.entity.Products;
import org.example.freespace.repository.ProductsJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaService {
    private final ProductsJpaRepository productsJpaRepository;

    public List<Products> retrieveProducts () {
        List<Products> products = productsJpaRepository.findAll();
        return products;
    }
}
