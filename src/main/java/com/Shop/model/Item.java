package com.Shop.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private Category category;
}
