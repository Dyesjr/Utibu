package com.hospital.hospitali.service;

import com.hospital.hospitali.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();


    ProductDto getProductDetails(Long productId);

    void createProduct(ProductDto productDto);
}
