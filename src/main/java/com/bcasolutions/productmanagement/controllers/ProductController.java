package com.bcasolutions.productmanagement.controllers;

import com.bcasolutions.productmanagement.exceptions.ResourceNotFoundException;
import com.bcasolutions.productmanagement.models.Product;
import com.bcasolutions.productmanagement.services.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ProductController {
    @Autowired
    private ProductSvc productSvc;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id)
    {
        return productSvc.getProduct(id);
    }

    @GetMapping
    public List<Product> listProducts()
    {
        return productSvc.listProducts();
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>> addProduct(@RequestBody Product product)
    {
        productSvc.addProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Map<String,Object>> updateProduct(@RequestParam int id,
                                                            @RequestBody Product product)
            throws ResourceNotFoundException
    {
        try
        {
            product.setId(id);
            productSvc.updateProduct(product);
        }
        catch (ResourceNotFoundException resourceNotFoundException)
        {
            throw resourceNotFoundException;
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Map<String,Object>> deleteProduct(@RequestParam int id) throws ResourceNotFoundException {
        try
        {
            this.productSvc.deleteProduct(id);
        }
        catch (ResourceNotFoundException resourceNotFoundException)
        {
            throw resourceNotFoundException;
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
