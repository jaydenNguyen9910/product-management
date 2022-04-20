package com.bcasolutions.productmanagement.services.impl;

import com.bcasolutions.productmanagement.exceptions.ResourceNotFoundException;
import com.bcasolutions.productmanagement.models.Product;
import com.bcasolutions.productmanagement.services.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bcasolutions.productmanagement.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductSvcImpl implements ProductSvc {
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) throws ResourceNotFoundException {
        Integer id = product.getId();
        Product existingProduct = productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id : "+ id));

        final Product updatedProduct = productRepository.save(product);
    }

    @Override
    @Transactional
    public Product getProduct(int id) {
        return productRepository.getById(id);
    }

    @Override
    @Transactional
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteProduct(int id) throws ResourceNotFoundException {
        Product existingProduct = productRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Product not found for this id : "+ id));

        productRepository.delete(existingProduct);
    }
}
