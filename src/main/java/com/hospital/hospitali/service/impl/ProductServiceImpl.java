package com.hospital.hospitali.service.impl;

import com.hospital.hospitali.dto.ProductDto;
import com.hospital.hospitali.entity.Product;
import com.hospital.hospitali.repository.ProductRepository;
import com.hospital.hospitali.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductDetails(Long productId) {
        // Retrieve the product entity from the database using the productId
        Product product = (Product) productRepository.findById(productId)
                .orElse(null);

        // If product is found, convert it to ProductDto and return
        if (product != null) {
            return convertToDto(product);
        } else {
            // If product is not found, return null or throw an exception based on your requirement
            return null;
        }
    }

    @Override
    public void createProduct(ProductDto productDto) {
        // Convert ProductDto to Product entity
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());

        // Save the product to the database
        productRepository.save(product);

    }

    private ProductDto convertToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
