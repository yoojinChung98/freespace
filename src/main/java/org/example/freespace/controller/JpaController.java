package org.example.freespace.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.freespace.entity.Products;
import org.example.freespace.service.JpaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/jpa")
@Slf4j
public class JpaController {

    private final JpaService jpaService;

    @PostMapping("/retrieve-all-products")
    public void retrieveAllProducts() {
        List<Products> products = jpaService.retrieveProducts();
        log.info("fin : retrieve all products");
    }
}
