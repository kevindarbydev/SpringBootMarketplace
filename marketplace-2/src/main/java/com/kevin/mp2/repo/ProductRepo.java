package com.kevin.mp2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.kevin.mp2.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
 
}