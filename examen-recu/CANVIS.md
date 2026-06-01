# Fitxer per explicar els canvis fets a cada branca

Activitat 1: 
  // TODO - ACTIVITAT 1
    @OneToMany
    private List<Product> products = new ArrayList<>();

    // TODO - ACTIVITAT 1
    @OneToOne
    private TechnicalSheet technicalSheet;

    // TODO - ACTIVITAT 1.
    @OneToOne
    private Category category;

    // TODO - ACTIVITAT 1
    @OneToMany
    private List<ProductTag> tags = new ArrayList<>();


      // TODO - ACTIVITAT 1
    @OneToMany
    private List<Product> products = new ArrayList<>();

      // TODO - ACTIVITAT 1
    @OneToOne
    private Product product;