package com.anuragbansall.learnSpring.controllers;

import com.anuragbansall.learnSpring.dto.ProductDto;
import com.anuragbansall.learnSpring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getAllProducts(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "2") Integer pageSize
    ) {

        return productService.getAllProducts(sortBy, page, pageSize);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto request) {

        return productService.createProduct(request);
    }
}
