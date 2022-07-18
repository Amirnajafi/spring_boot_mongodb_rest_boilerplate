package com.amir.test.products;

import com.amir.test.models.Products;
import com.amir.test.models.Users;
import com.amir.test.products.dto.CreateProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Products updateProducts(CreateProductDto body , Users user){
        if (productRepository.existsById(body.getId())){
            Optional<Products> product = productRepository.findById(body.getId());
            Products product_builder = Products.builder()
                    .id(body.getId())
                    .name(body.getName())
                    .category(body.getCategory())
                    .price(body.getPrice())
                    .description(body.getDescription())
                    .user(user)
                    .build();

            if (body.getName() == null){
                product_builder.setName(product.get().getName());
            }
            if (body.getPrice() == null){
                product_builder.setPrice(product.get().getPrice());
            }
            if (body.getCategory() == null){
                product_builder.setCategory(product.get().getCategory());
            }

            if (body.getDescription() == null){
                product_builder.setDescription(product.get().getDescription());
            }
            productRepository.save(product_builder);
            return product_builder;
        }else{
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, "product not found");
        }
    }

    public String removeProduct(String id, Users user){
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
            return id;
        }else{
            throw new ResponseStatusException( HttpStatus.NOT_FOUND, "product not found");
        }
    }



}
