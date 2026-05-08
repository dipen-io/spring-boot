package com.example.demo.service;

import com.example.demo.model.ProductDTO;
import java.util.*;

public interface ProductService {
    List<ProductDTO> getAllProduct();
    Optional<ProductDTO> getProductById(Long id);
    ProductDTO saveProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
}
