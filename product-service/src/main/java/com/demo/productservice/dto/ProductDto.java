package com.demo.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters, setters, toString(), equals(), and hashCode()
@NoArgsConstructor // Required by Jackson for deserialization (to create the object)
@AllArgsConstructor // Used by the AccountMapper for mapping (to populate the object)
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
}
