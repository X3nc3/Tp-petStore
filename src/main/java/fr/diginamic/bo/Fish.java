package fr.diginamic.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

/**Classe fille representant le concept de de poisson**/
@Entity
@Table(name = "FISH")
public class Fish extends Animal{

    /**Variable d'instance**/
    @Column(name = "FISH_LIV_ENV")
    private FishLivEnv linvingEnv;

    /**Constructeur vide pour JPA**/
    public Fish() {
    }

    /**Constructeur pour objet Fish
     *
     * @param birth
     * @param couleur
     * @param petStore
     * @param linvingEnv
     */
    public Fish(Date birth, String couleur, PetStore petStore, FishLivEnv linvingEnv) {
        super(birth, couleur, petStore);
        this.linvingEnv = linvingEnv;
    }

    /**
     * Getter
     *
     * @return linvingEnv
     */
    public FishLivEnv getLinvingEnv() {
        return linvingEnv;
    }

    /**
     * Setter
     *
     * @param linvingEnv linvingEnv
     */
    public void setLinvingEnv(FishLivEnv linvingEnv) {
        this.linvingEnv = linvingEnv;
    }

    /**Méthode toString**/
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fish{");
        sb.append("linvingEnv=").append(linvingEnv);
        sb.append('}');
        return sb.toString();
    }
}
