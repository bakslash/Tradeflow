package com.demo.productservice.serviceImpl;

import com.demo.productservice.dto.ProductDto;
import com.demo.productservice.entity.Product;
import com.demo.productservice.mapper.ProductMapper;
import com.demo.productservice.repository.ProductRepository;
import com.demo.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    /**
     * Creates and saves a new product in the database.
     *
     * @param productDto Product details to create.
     * @return Created ProductDto.
     */
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        logger.info("[ProductService] Creating product: {}", productDto.getName());

        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);

        logger.info("[ProductService] Product created successfully with ID: {}", savedProduct.getId());
        return ProductMapper.mapToProductDto(savedProduct);
    }

    /**
     * Fetches all products from the database.
     *
     * @return List of ProductDto.
     */
    @Override
    public List<ProductDto> getProducts() {
        logger.info("[ProductService] Fetching all products...");
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::mapToProductDto)
                .toList();
    }
}
