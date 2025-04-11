package org.example.freespace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Categories {
    //
    @Id
    private int categoryId;
    private String categoryName;
    private String description;
}
