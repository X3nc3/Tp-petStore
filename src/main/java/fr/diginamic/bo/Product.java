package fr.diginamic.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**Classe representant le concept de produit**/
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    /**Variable d'instance**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "LABEL")
    private String label;
    @Column(name = "TYPE")
    private ProdType type;
    @Column(name = "PRICE")
    private double price;
    @ManyToMany(mappedBy = "products")
    private Set<PetStore> petStores;

    /**Initialisation de la liste petStores**/
    {
        petStores = new HashSet<>();
    }

    /**Constructeur vide pour JPA**/
    public Product() {
    }

    /**Constructeur pour objet Product
     *
     * @param code
     * @param label
     * @param type
     * @param price
     */
    public Product(String code, String label, ProdType type, double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    /**Méthode pour ajouter un petStore dans la liste de product**/
    public void ajouterPetStore(PetStore petStore) {
        if (petStore != null) {
            petStore.ajouterProducts(this);
        }
    }

    /**
     * Getter
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter
     *
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter
     *
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter
     *
     * @param label label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Getter
     *
     * @return type
     */
    public ProdType getType() {
        return type;
    }

    /**
     * Setter
     *
     * @param type type
     */
    public void setType(ProdType type) {
        this.type = type;
    }

    /**
     * Getter
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter
     *
     * @param price price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter
     *
     * @return petStores
     */
    public Set<PetStore> getPetStores() {
        return petStores;
    }

    /**
     * Setter
     *
     * @param petStores petStores
     */
    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    /**Méthode toString**/
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", label='").append(label).append('\'');
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
