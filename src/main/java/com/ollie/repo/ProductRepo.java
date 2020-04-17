package com.ollie.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ollie.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
