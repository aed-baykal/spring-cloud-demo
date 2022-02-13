package ru.gb.eurekaclientview;

import lombok.Data;

@Data
public class Product {

    private Long id;
    private String title;
    private String price;
    private String category;
}
