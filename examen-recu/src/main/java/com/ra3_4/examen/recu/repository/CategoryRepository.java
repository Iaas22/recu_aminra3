package com.ra3_4.examen.recu.repository;

import com.ra3_4.examen.recu.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}