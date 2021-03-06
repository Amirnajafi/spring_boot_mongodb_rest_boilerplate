package com.amir.test.products.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {
    private String id;
    private String name;
    private String description;
    private Long price;
    private String category;
}
