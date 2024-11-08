package fr.diginamic.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**Classe representant le concepte de magasin d'animals**/
@Entity
@Table(name = "PET_STORE")
public class PetStore implements Serializable {

    /**Variable d'instance**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MANAGER_NAME")
    private String managerName;
    @OneToOne
    @JoinColumn(name = "ID_ADRESSE")
    private Adresse adresse;
    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private Set<Animal> animals;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "STOCK", joinColumns = @JoinColumn(name = "ID_PET_STORE", referencedColumnName = "ID"),
    inverseJoinColumns = @JoinColumn(name = "ID_PRODUCT", referencedColumnName = "ID"))
    private Set<Product> products;

    /**Initialisation des listes animals et products**/
    {
        animals = new HashSet<>();
        products = new HashSet<>();
    }

    /**Constructeur vide pour JPA**/
    public PetStore() {
    }

    /**Constructeur pour objet PetStore
     *
     * @param name
     * @param managerName
     * @param adresse
     */
    public PetStore(String name, String managerName, Adresse adresse) {
        this.name = name;
        this.managerName = managerName;
        this.adresse = adresse;
    }

    /**Méthode pour ajouter un animal dans la liste de petStore **/
    public void ajouterAnimal(Animal animal) {
        animal.setPetStore(this);
    }

    /**Méthode pour ajouter un product dans la liste de petStore et ajouter un petStore dans la liste de product**/
    public void ajouterProducts(Product product) {
        if (product != null) {
            this.products.add(product);
            product.getPetStores().add(this);
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     *
     * @return managerName
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Setter
     *
     * @param managerName managerName
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * Getter
     *
     * @return adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Setter
     *
     * @param adresse adresse
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Getter
     *
     * @return animals
     */
    public Set<Animal> getAnimals() {
        return animals;
    }

    /**
     * Setter
     *
     * @param animals animals
     */
    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    /**
     * Getter
     *
     * @return products
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Setter
     *
     * @param products products
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    /**Méthode toString**/
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PetStore{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", managerName='").append(managerName).append('\'');
        sb.append(", adresse=").append(adresse);
        sb.append('}');
        return sb.toString();
    }
}
