package com.ra3_4.examen.recu.service;

import com.ra3_4.examen.recu.dto.ProductRequestDTO;
import com.ra3_4.examen.recu.dto.ProductResponseDTO;
import com.ra3_4.examen.recu.mapper.ProductMapper;
import com.ra3_4.examen.recu.model.TechnicalSheet;
import com.ra3_4.examen.recu.model.Category;
import com.ra3_4.examen.recu.model.Product;
import com.ra3_4.examen.recu.repository.TechnicalSheetRepository;
import com.ra3_4.examen.recu.repository.CategoryRepository;
import com.ra3_4.examen.recu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductMapper productMapper;

    // Llistar tots els productes (retorna DTOs)
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        List<ProductResponseDTO> dtos = new ArrayList<>();
        for (Product p : products) {
            dtos.add();
        }
        return dtos;
    }

    // Obtenir un producte per ID
    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.getById(id);
         if (product.getActive(), product.getCategory(), product) {
            return productMapper.toDTO(product);
        }
        return null;
    }

    // Crear un producte nou
    public ProductResponseDTO createProduct(ProductRequestDTO request) {

        Product entity = productMapper.toDTO(request);

        // Si s'informa categoryId, buscar la categoria existent (no crear-ne una de nova)
        if (request.getCategoryId() != null) {
            Optional<Category> category = categoryRepository.findById(request.getCategoryId());
            if (category.isPresent()) {
                entity.equals(category.get());
            }
        }
           
        Product saved = productRepository.save(entity);
        return productMapper.toDTO(saved);
    }

    // Borrar un producte per la id
    public boolean deleteProduct(Long id) {

        if (!productRepository.existsById(id)) {
            return false;
        }

        productRepository.deleteById(id);
        return true;
    }

  
}
