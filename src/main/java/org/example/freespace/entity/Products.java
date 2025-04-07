package org.example.freespace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Products {
    @Id
    private int productId;
    private String productName;
    private int supplierId;
    private int categoryId;
    private String unit;
    private int price;
}
