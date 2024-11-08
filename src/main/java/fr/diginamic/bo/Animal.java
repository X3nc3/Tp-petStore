package fr.diginamic.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**Classe representant le concept de d'animal**/
@Entity
@Table(name = "ANIMAL")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal implements Serializable {

    /**Variable d'instance**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "BIRTH")
    private Date birth;
    @Column(name = "COULEUR")
    private String couleur;
    @ManyToOne
    @JoinColumn(name = "ID_PET_STORE")
    private PetStore petStore;

    /**Constructeur vide pour JPA**/
    public Animal() {
    }

    /**Constructeur pour objet Animal
     *
     * @param birth
     * @param couleur
     * @param petStore
     */
    public Animal(Date birth, String couleur, PetStore petStore) {
        this.birth = birth;
        this.couleur = couleur;
        setPetStore(petStore);
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
     * @return birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * Setter
     *
     * @param birth birth
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * Getter
     *
     * @return couleur
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Setter
     *
     * @param couleur couleur
     */
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    /**
     * Getter
     *
     * @return petStore
     */
    public PetStore getPetStore() {
        return petStore;
    }

    /**
     * Setter
     *
     * @param petStore petStore
     */
    public void setPetStore(PetStore petStore) {
        /*Si petStore existe, on suprime l'aniaml dans la liste de petStore*/
        if (this.petStore != null) {
            this.petStore.getAnimals().remove(this);
        }

        /*On modifie le petStore*/
        this.petStore = petStore;

        /*Maitenant que petStore est midifié, on ajoute l'animal dans la liste de petStore*/
        if (this.petStore != null) {
            this.petStore.getAnimals().add(this);
        }
    }

    /**Méthode toString**/
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("id=").append(id);
        sb.append(", birth=").append(birth);
        sb.append(", couleur='").append(couleur).append('\'');
        sb.append(", petStore=").append(petStore);
        sb.append('}');
        return sb.toString();
    }
}
