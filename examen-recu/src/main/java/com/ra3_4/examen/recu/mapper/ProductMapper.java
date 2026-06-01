package com.ra3_4.examen.recu.mapper;

import org.springframework.stereotype.Component;

import com.ra3_4.examen.recu.dto.ProductRequestDTO;
import com.ra3_4.examen.recu.dto.ProductResponseDTO;
import com.ra3_4.examen.recu.model.Product;


@Component
public class ProductMapper {

    // TODO activitat2: Implementa tots els espais en blanc

    public ProductResponseDTO toDTO(Product p) {
        
        if(__) return null; // null-safety

        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(__);
        dto.setName(__);
        dto.setDescription(__);
        dto.setPrice(__);
        dto.setStock(__);

       
        if (__ != null) {
            dto.setColor(__);
        }

        return dto;
    }

    
    public Product toEntity() {
        Product product = new Product();

        // TODO activitat2: mapeja els camps name, description, price i stock del DTO a l'entitat

        // TODO activitat2: crea un objecte TechnicalSheet amb els camps weight i color del DTO
        //                  i assigna'l al producte

        return product;
    }
}
