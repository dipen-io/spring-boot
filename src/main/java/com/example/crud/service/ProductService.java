package com.example.crud.service;

import com.example.crud.model.ProductDTO;
import java.util.*;

public interface ProductService {
    List<ProductDTO> getAllProduct();
    Optional<ProductDTO> getProductById(Long id);
    ProductDTO saveProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    ProductDTO updateProductPartial(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
}
