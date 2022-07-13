package com.amir.test.products;

import com.amir.test.models.Products;
import com.amir.test.models.Users;
import com.amir.test.products.dto.CreateProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductsService {
    private final ProductRepository productRepository;

    public List<Products> getAllProducts(){
        return productRepository.findAll();

    }
    public Products createProduct(CreateProductDto body , Users user){
        Products product = Products.builder()
                .name(body.getName())
                .description(body.getDescription())
                .category(body.getCategory())
                .price(body.getPrice())
                .user(user)
                .build();
        productRepository.save(product);
        return product;
    }
}
