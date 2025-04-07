package org.example.freespace.repository;

import org.example.freespace.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

// Jpa 기본 Repository. 인터페이스 타입으로 생성한다
public interface ProductsJpaRepository extends JpaRepository<Products, Long> {
    // 커스텀 쿼리가 추가적으로 필요하다면 Spring jpa query method 형식에 맞추어 추가할 수 있음.
}
