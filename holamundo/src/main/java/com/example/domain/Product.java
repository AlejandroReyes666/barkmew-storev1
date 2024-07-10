package com.example.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private  int productId;
    private String name;
    private int CategoryId;
    private double price;
    private int stock;
    private Boolean active;
    private Category category;
}
