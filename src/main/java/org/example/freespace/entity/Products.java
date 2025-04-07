package org.example.freespace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "PRODUCTS")
public class Products {
    @Id
    private int productId;
    private String productname;
    private int supplierId;
    private int categoryId;
    private String unit;
    private int price;
}
