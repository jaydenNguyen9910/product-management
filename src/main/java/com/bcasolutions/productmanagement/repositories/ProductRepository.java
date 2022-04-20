package com.bcasolutions.productmanagement.repositories;

import com.bcasolutions.productmanagement.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
