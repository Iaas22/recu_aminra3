package com.ra3_4.examen.recu.mapper;

import org.springframework.stereotype.Component;

import com.ra3_4.examen.recu.dto.ProductRequestDTO;
import com.ra3_4.examen.recu.dto.ProductResponseDTO;
import com.ra3_4.examen.recu.model.Product;
import com.ra3_4.examen.recu.model.TechnicalSheet;


@Component
public class ProductMapper {

    // TODO activitat2: Implementa tots els espais en blanc

    public ProductResponseDTO toDTO(Product p) {
        
        if() return null; // null-safety

        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setDescription(p.getDescription());
        dto.setPrice(p.getPrice());
        dto.setStock(p.getStock());

       
        if (p != null) {
            dto.setColor(__);
        }

        return dto;
    }

    
    public Product toEntity() {
        Product product = new Product();

        TechnicalSheet sheet = new Sheet(String color);

        

        // TODO activitat2: mapeja els camps name, description, price i stock del DTO a l'entitat

        // TODO activitat2: crea un objecte TechnicalSheet amb els camps weight i color del DTO
        //                  i assigna'l al producte

        return product;
    }
}
