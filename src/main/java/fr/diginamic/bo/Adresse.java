package fr.diginamic.bo;

import jakarta.persistence.*;

import java.io.Serializable;

/**Classe representant le concept de d'adresse**/
@Entity
@Table(name = "ADRESSE")
public class Adresse implements Serializable {

    /**Variable d'instance**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "STREET")
    private String street;
    @Column(name = "ZIP_CODE")
    private String zipCode;
    @Column(name = "CITY")
    private String city;
    @OneToOne(mappedBy = "adresse")
    private PetStore petStore;

    /**Constructeur vide pour JPA**/
    public Adresse() {
    }

    /**Constructeur pour objet Adresse
     *
     * @param number
     * @param street
     * @param zipCode
     * @param city
     */
    public Adresse(String number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
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
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Setter
     *
     * @param number number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Getter
     *
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter
     *
     * @param street street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter
     *
     * @return zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Setter
     *
     * @param zipCode zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Getter
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter
     *
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
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
        this.petStore = petStore;
    }

    /**Méthode toString**/
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adresse{");
        sb.append("id=").append(id);
        sb.append(", number='").append(number).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", petStore=").append(petStore);
        sb.append('}');
        return sb.toString();
    }
}
