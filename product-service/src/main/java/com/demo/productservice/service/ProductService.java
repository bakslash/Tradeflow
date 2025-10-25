package com.demo.productservice.service;

import com.demo.productservice.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    //ProductDto updateProduct(ProductDto productDto);
    //void deleteProduct(Long id);
    // ProductDto getAllProducts();
    //ProductDto getProductById(Long id);

    List<ProductDto> getProducts();
}
