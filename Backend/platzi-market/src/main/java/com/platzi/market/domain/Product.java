package com.platzi.market.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private int producId;
    private String name;
    private int categoryId;
    private BigDecimal price;
    private int stock;
    private boolean active;
    private Category category;

}
