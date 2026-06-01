# EXAMEN PRÀCTIC — RA3 + RA4
**Mòdul:** Accés a Dades (0486)
**Resultats d'Aprenentatge:** RA3 (Spring JPA, JPQL, Transaccions, Mappers, DTO) + RA4 (Model Relacional, Relacions JPA)
**Tecnologia:** Spring Boot / Java / Spring Data JPA / MySQL
**Nivell:** Pràctic (FP Dual)
**Data:** Juny 2026

---

## DISSENY DE BASE DE DADES

```
+------------------+             +--------------------+
| technical_sheets |             |     categories     |
+------------------+             +--------------------+
| id (PK, BIGINT)  |             | id (PK, BIGINT)    |
| color (VARCHAR)  |             | name (VARCHAR)     |
| weight (VARCHAR) |             | description (TEXT) |
+------------------+             +--------------------+                    
        | 1                           | 1
        |                             | 
        |                             |
        | 1                           | N
        v                             v
+---------------------------------------------------+
|                    products                       |
+---------------------------------------------------+
| id           (PK, BIGINT, IDENTITY)               |
| name         (VARCHAR(200), NOT NULL)             |
| description  (TEXT)                               |
| price        (DOUBLE, NOT NULL)                   |
| stock        (INT, NOT NULL)                      |
| category_id  (FK → categories.id)                 |
| technical_sheet_id  (FK → technical_sheets.id)    |
| active       (BOOLEAN)                            |
| data_created (DATETIME, CreationTimestamp)        |
| data_updated (DATETIME, UpdateTimestamp)          |
+---------------------------------------------------+
        | N
        |
        | M  (via product_tag_rel)
        v
+---------------------+     +------------------------+
|    product_tags     |     |   product_tag_rel      |
+---------------------+     +------------------------+
| id (PK, BIGINT)     |<----| product_id (FK)        |
| name (VARCHAR)      |     | tag_id(FK)     |
| active (BOOLEAN)    |     +------------------------+
+---------------------+     (taula intermediària)



RELACIONS JPA:
- Product  (1) → (1) TechnicalSheet       [@OneToOne]
- Category (1) → (N) Product              [@OneToMany / @ManyToOne]
- Product  (N) ↔ (N) ProductTag           [@ManyToMany]
```

REGLES DE NEGOCI
- Una Category pot tenir molts Products, i cada Product pertany a exactament una Category.
    - Si s'esborra una Category, els seus Products no s'esborren automàticament.

- Cada Product té exactament una TechnicalSheet, i cada TechnicalSheet pertany exactament a un Product.
    - Al crear un Product, s'ha de crear també la seva TechnicalSheet automàticament.
    - Al esborrar un Product, també s'esborra la seva TechnicalSheet automàticament.
    - Al consultar un Product, també ha de retornar la informació de la TechnicalSheet automàticament.

- Un Product pot tenir molts Tags, i un Tag pot estar associat a molts Products.
    - La taula pont s'ha de dir product_tag_rel, amb columnes producte_id i tag_id.
---

## TASQUES A REALITZAR

# PART RA4

### ACTIVITAT 1 — Completar les entitats JPA `⏱ Temps estimat: 30 min`

**Instrucció:**
> Quan tinguis aquesta part feta fes un commit 'Activitat 1'. En `CANVIS.md` detalla els canvis fets i per quin motiu cada anotació és necessària.

---

** Implementar les relacions JPA **

Per cada `// TODO` has de:
1. Afegir les anotacions correctes (`@OneToMany`, `@ManyToOne`, `@OneToOne`, `@ManyToMany`, `@JoinColumn`, `@JoinTable`, etc.)
2. Especificar el `cascade` i el `fetch` adequats segons les regles de negoci descrites.
3. Afegir `mappedBy` si és necessari.

---

# PART RA3

---

### ACTIVITAT 2 — Implementar el Mapper `⏱ Temps estimat: 25 min`

**Descripció:**
Implementa el `ProductMapper.java` complet: afegeix l'anotació necessària i implementa els mètodes `toDto()` i `toEntity()`.

**Instrucció:**
> Quan tinguis aquesta part feta fes un commit 'Activitat 2'. En CANVIS.md detalla els canvis fets i per quin motiu cada anotació és necessària.

---

### ACTIVITAT 3 — Implementar el Services `⏱ Temps estimat: 30 min`
**Descripció**: 
Modifica o corregeix el services per a que sigui funcional i sense errors.

**Instrucció:**
> Quan tinguis aquesta part feta fes un commit 'Activitat 3'. En CANVIS.md detalla els canvis fets i per quin motiu cada anotació és necessària.



### ACTIVITAT 4 — Implementació d'un endpoint `⏱ Temps estimat: 35 min`

**Descripció:**
Implementa un endpoint que retorni els productes que tenen un preu entre un min i un max i el camp active true.
Els productes que es retornen no tindran informat la categoria.

**Instrucció:**
> Quan tinguis aquesta part feta fes un commit 'Activitat 4'. En CANVIS.md detalla els canvis fets i per quin motiu cada anotació és necessària.

---

## Criteri d'Avaluació

| Activitat | Contingut | Pts |
|---|---|---|
| Activitat 1 | Relacions JPA (cascade, fetch, mappedBy, JoinTable) | 2.5 |
| Activitat 2 | Mapper (transformació DTO ↔ Entity, null-safety) | 2.5 |
| Activitat 3 | Service (Optional, repositoris, lògica de negoci) | 2.5 |
| Activitat 4 | JPQL + Service + Controller complets | 2.5 |
| **TOTAL** | | **10** |



