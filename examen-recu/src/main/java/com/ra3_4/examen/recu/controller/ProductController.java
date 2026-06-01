package com.ra3_4.examen.recu.controller;

import com.ra3_4.examen.recu.dto.ProductRequestDTO;
import com.ra3_4.examen.recu.dto.ProductResponseDTO;
import com.ra3_4.examen.recu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET /api/products
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // GET /api/products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // POST /api/products
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(request));
    }

    // DELETE /api/products/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    // TODO activitat 4 - endpoint :
    // GET /api/products/price-range?priceMin=&priceMax=

    @GetMapping("/api/products/pice-range?priceMin=&priceMax=")
        public ResponseEntity<List<ProductResponseDTO>> getProductsById(@PathVariable id) {
            return ResponseEntity.ok(productService.getProductById(id));


    }
    // Ha de retornar ResponseEntity<List<ProductResponseDTO>> dels productes que tenen un preu entre un min i un max i status true

    
}