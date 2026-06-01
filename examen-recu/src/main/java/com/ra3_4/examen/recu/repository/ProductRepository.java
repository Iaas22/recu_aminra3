package com.ra3_4.examen.recu.repository;

import com.ra3_4.examen.recu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // TODO activitat 1 - endpoint 1:
    // Query Derivation: retorna productes on el nom contingui el prefix i status sigui true
    // Paràmetre: String prefix
    // Ha de retornar List<Product>

    // TODO activitat 1 - endpoint 2:
    // JPQL: retorna productes on el preu estigui entre priceMin i priceMax (ambdós inclosos) i status sigui true
    // Paràmetres: Double priceMin, Double priceMax
    // Ha de suportar ordenació per camp i direcció (asc/desc) i límit de resultats
    // Ha de retornar List<Product>

    // Consulta JPQL per buscar productes amb preu menor que el màxim
    @Query("SELECT p FROM Product p WHERE p.price <= :maxPrice ORDER BY p.price ASC")
    List<Product> findByMaxPrice(@Param("maxPrice") Double maxPrice);

    // TODO activitat4: afegeix una consulta JPQL per buscar per nom de marca
    // @Query("SELECT p FROM Product p WHERE p.brand.name = :brandName")
}