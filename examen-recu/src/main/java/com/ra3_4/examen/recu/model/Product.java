package com.ra3_4.examen.recu.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stock;

    private Boolean active = true;

    // TODO - ACTIVITAT 1
    @OneToOne
    private TechnicalSheet technicalSheet;

    // TODO - ACTIVITAT 1.
    @OneToOne
    private Category category;

    // TODO - ACTIVITAT 1
    @OneToMany
    private List<ProductTag> tags = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "data_created", updatable = false)
    private LocalDateTime dataCreated;

    @UpdateTimestamp
    @Column(name = "data_updated")
    private LocalDateTime dataUpdated;

    // Getters i Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public TechnicalSheet getTechnicalSheet() { return technicalSheet; }
    public void setTechnicalSheet(TechnicalSheet technicalSheet) { this.technicalSheet = technicalSheet; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public LocalDateTime getDataCreated() { return dataCreated; }
    public LocalDateTime getDataUpdated() { return dataUpdated; }
    public List<ProductTag> getTags() { return tags; }
    public void setTags(List<ProductTag> tags) { this.tags = tags; }
    public Boolean getActive() {return active;}
    public void setActive(Boolean active) {this.active = active;}
}