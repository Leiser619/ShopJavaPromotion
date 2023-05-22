package com.Shop.dto;

import com.Shop.model.Category;
import lombok.Data;

@Data
public class RequestItem {

    private String name;

    private int price;

    private Category category;
}
