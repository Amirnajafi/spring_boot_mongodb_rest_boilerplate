package com.amir.test.products;

import com.amir.test.models.Products;
import com.amir.test.models.Users;
import com.amir.test.products.dto.CreateProductDto;
import com.amir.test.users.UsersService;
import com.amir.test.users.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;
    private final UsersService usersService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Products addUser(@Valid @RequestBody CreateProductDto body , Principal principal){
        Users user = usersService.getUserByUsername(principal.getName());
        return productsService.createProduct(body , user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Products> getUsers(Principal principal){
        return  productsService.getAllProducts();

    }
}
