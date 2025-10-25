package com.demo.productservice.mapper;

import com.demo.productservice.dto.ProductDto;
import com.demo.productservice.entity.Product;

/**
 * A utility class for mapping between Account entity and AccountDto.
 * This helps in separating the database layer (entity) from the API layer (DTO).
 */
public class ProductMapper {

    /**
     * Maps an AccountDto object to an Account entity object.
     * This is typically used when receiving data from an API call to be saved in the database.
     *
     * @param productDto The Data Transfer Object to be converted.
     * @return The corresponding Account entity.
     */
    public static Product mapToProduct(ProductDto productDto) {
        // Create a new Account entity using the data from the DTO.
        Product product = new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice()

        );
        return product;
    }

    /**
     * Maps an Account entity object to an AccountDto object.
     * This is typically used when sending data from the database as a response to an API call.
     *
     * @param product The Account entity to be converted.
     * @return The corresponding AccountDto.
     */
    public static ProductDto mapToProductDto(Product product) {
        // Create a new AccountDto using the data from the entity.
        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()


        );
        return productDto;
    }
}