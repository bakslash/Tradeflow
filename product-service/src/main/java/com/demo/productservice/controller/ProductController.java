package com.demo.productservice.controller;

import com.demo.productservice.dto.ProductDto;
import com.demo.productservice.service.ProductService;
import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing products.
 * Provides endpoints to create and retrieve products.
 */
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    /**
     * Creates a new product.
     *
     * @param productDto the product data to create
     * @return the created product with status 201 (Created)
     */
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        log.info("[ProductController] Received request to create product: {}", productDto.getName());
        ProductDto createdProduct = productService.createProduct(productDto);
        log.info("[ProductController] Product created successfully: {}", createdProduct.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    /**
     * Fetches all available products.
     *
     * @return list of ProductDto with status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        log.info("[ProductController] Fetching all products...");
        List<ProductDto> products = productService.getProducts();
        log.info("[ProductController] Found {} products", products.size());
        return ResponseEntity.ok(products);
    }
}
