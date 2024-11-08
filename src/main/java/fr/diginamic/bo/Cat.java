package fr.diginamic.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

/**Classe fille representant le concept de de chat**/
@Entity
@Table(name = "CAT")
public class Cat extends Animal {

    /**Variable d'instance**/
    @Column(name = "CHIPLD")
    private String chipld;

    /**Constructeur vide pour JPA**/
    public Cat() {
    }

    /**Constructeur pour objet Cat
     *
     * @param birth
     * @param couleur
     * @param petStore
     * @param chipld
     */
    public Cat(Date birth, String couleur, PetStore petStore, String chipld) {
        super(birth, couleur, petStore);
        this.chipld = chipld;
    }

    /**
     * Getter
     *
     * @return chipld
     */
    public String getChipld() {
        return chipld;
    }

    /**
     * Setter
     *
     * @param chipld chipld
     */
    public void setChipld(String chipld) {
        this.chipld = chipld;
    }

    /**Méthode toString**/
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cat{");
        sb.append("chipld='").append(chipld).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
