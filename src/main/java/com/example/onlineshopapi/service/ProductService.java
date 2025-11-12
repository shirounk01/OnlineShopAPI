package com.example.onlineshopapi.service;

import com.example.onlineshopapi.entity.Product;
import com.example.onlineshopapi.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Page<Product> getAllProducts(int page, int size){

        return productRepository.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    public Product getProduct(Long id){
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }
}
