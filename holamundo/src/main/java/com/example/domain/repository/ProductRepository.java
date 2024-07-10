package com.example.domain.repository;

import com.example.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScareproducts(int quantity);

    Product save (Product product);
    void  delete (int productId);

}
