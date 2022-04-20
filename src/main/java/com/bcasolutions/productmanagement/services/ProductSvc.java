package com.bcasolutions.productmanagement.services;

import com.bcasolutions.productmanagement.exceptions.ResourceNotFoundException;
import com.bcasolutions.productmanagement.models.Product;

import java.util.List;

public interface ProductSvc {
    public void addProduct(Product product);
    public void updateProduct(Product product) throws ResourceNotFoundException;
    public Product getProduct(int id);
    public List<Product> listProducts();
    public void deleteProduct(int id) throws ResourceNotFoundException;
}
