package com.example.crud.service.impl;

import com.example.crud.model.Product;
import com.example.crud.model.ProductDTO;
import com.example.crud.repository.ProductRepository;
import com.example.crud.service.ProductService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        return productRepository
            .findAll()
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());
        Product updatedProduct = productRepository.save(product);
        return convertToDTO(updatedProduct);
    }

    @Override
    public ProductDTO updateProductPartial(Long id, ProductDTO productDTO) {
        Product product = productRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        if (productDTO.name() != null) {
            product.setName(productDTO.name());
        }

        if (productDTO.description() != null) {
            product.setDescription(productDTO.description());
        }

        if (productDTO.price() != null) {
            product.setPrice(productDTO.price());
        }

        Product updatedProduct = productRepository.save(product);
        return convertToDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    /*
    Convertion logic betweenDTO and Entity placed in serivce
    convertToDTO := Converts a Product entity into a ProductDTO
    convertTOEntity := Convert a ProductDTO into a Product entity
    */

    // convert Product Entity to ProductDTO
    private ProductDTO convertToDTO(Product product) {
        return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getDescrition(),
            product.getPrice()
        );
    }

    // Convert ProductDTO to Product Entity
    private Product convertToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());
        return product;
    }
}
