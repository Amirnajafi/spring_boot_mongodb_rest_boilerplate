package com.amir.test.products;

import com.amir.test.models.Products;
import com.amir.test.models.Users;
import com.amir.test.products.dto.CreateProductDto;
import com.amir.test.products.dto.RemoveProductDto;
import com.amir.test.users.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;
    private final UsersService usersService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Products> getUsers(Principal principal){
        return  productsService.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Products addUser(@Valid @RequestBody CreateProductDto body , Principal principal){
        Users user = usersService.getUserByUsername(principal.getName());
        return productsService.createProduct(body , user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Products updateUser(@Valid @RequestBody CreateProductDto body , Principal principal){
        Users user = usersService.getUserByUsername(principal.getName());
        return productsService.updateProducts(body , user);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String removeProducts(@Valid @RequestBody RemoveProductDto body , Principal principal){
        Users user = usersService.getUserByUsername(principal.getName());
        return productsService.removeProduct(body.getId() , user);
    }

}
