package com.demo.productservice.controller;

import com.demo.productservice.dto.ProductDto;
import com.demo.productservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing bank accounts.
 * The @RestController annotation combines @Controller and @ResponseBody,
 * making it easy to create RESTful web services.
 * The @RequestMapping("/api/accounts") sets the base path for all endpoints in this controller.
 */
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    // Logger instance for logging events within this class.
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    // The service layer dependency that handles the business logic.
    private ProductService productService;

    /**
     * Constructor for dependency injection of the AccountService.
     * Spring will automatically inject the AccountService bean.
     *
     * @param productService The service to be injected.
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * REST API endpoint to create a new account.
     * It handles HTTP POST requests to "/api/accounts".
     *
     * @param productDto The account data sent in the request body. The @RequestBody
     *                   annotation tells Spring to deserialize the JSON request body
     *                   into an AccountDto object.
     * @return A ResponseEntity containing the created AccountDto and an HTTP status of 201 (CREATED).
     */
    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        // Log the incoming request details.
        logger.info("Received POST request to create a new product with data: {}", productDto);

        // Call the service layer to perform the business logic of creating the account.
        ProductDto savedProductDto = productService.createProduct(productDto);

        // Log the successful creation and the response being sent.
        logger.info("Successfully created product. Responding with HTTP status CREATED.");

        // Wrap the saved DTO in a ResponseEntity with a 201 CREATED status.
        return new ResponseEntity<>(savedProductDto, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getAllProducts() {

        logger.info("Received GET controller request to get all products");
        return productService.getProducts();

    }
}