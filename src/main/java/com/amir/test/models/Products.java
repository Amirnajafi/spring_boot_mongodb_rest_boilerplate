package com.amir.test.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Products {
    @Id
    private String id;
    private String name;
    private String description;
    private Long price;
    private String category;
    @DBRef
    private Users user;
}
