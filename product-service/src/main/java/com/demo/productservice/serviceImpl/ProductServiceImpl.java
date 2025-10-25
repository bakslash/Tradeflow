package com.demo.productservice.serviceImpl;

import com.demo.productservice.dto.ProductDto;
import com.demo.productservice.entity.Product;
import com.demo.productservice.mapper.ProductMapper;
import com.demo.productservice.repository.ProductRepository;
import com.demo.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.demo.productservice.mapper.ProductMapper.mapToProductDto;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    /**
     * Creates a new product and saves it to the database.
     *
     * @param productDto The DTO containing the product details.
     * @return The saved product as a DTO.
     */
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        logger.info("[createProduct] Attempting to create product: {}", productDto.getName());

        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);

        logger.info("[createProduct] Product created successfully with ID: {}", savedProduct.getId());
        return mapToProductDto(savedProduct);
    }

    /**
     * Fetches all products from the database.
     *
     * @return List of ProductDto objects.
     */
    @Override
    public List<ProductDto> getProducts() {
        logger.info("[getProducts] Fetching all products...");
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::mapToProductDto).toList();
    }
}
