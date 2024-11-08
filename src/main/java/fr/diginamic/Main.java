package fr.diginamic;

import fr.diginamic.bo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        /*Creation d'objet Adresse*/
        Adresse adresse1 = new Adresse("1", "rue de paris", "75010", "Paris");
        Adresse adresse2 = new Adresse("2", "rue de paris", "75011", "paris");
        Adresse adresse3 = new Adresse("3", "rue de paris", "75012", "paris");

        /*Creation d'objet PetStore*/
        PetStore petStore1 = new PetStore("toto", "Noé", adresse1);
        PetStore petStore2 = new PetStore("tata", "Lisa", adresse2);
        PetStore petStore3 = new PetStore("tutu", "Luc", adresse3);

        /*Creation dobjet Product*/
        Product product1 = new Product("1", "eco", ProdType.ACCESSORY, 9.99);
        Product product2 = new Product("2", "bio", ProdType.FOOD, 19.99);
        Product product3 = new Product("3", "toxic", ProdType.CLEANING, 29.99);

        /*Creation d'objet Animal, Fish et cat*/
        Fish fish1 = new Fish(new Date(), "red", petStore1, FishLivEnv.FRESH_WATER);
        Fish fish2 = new Fish(new Date(), "pink", petStore2, FishLivEnv.SEA_WATER);
        Cat cat1 = new Cat(new Date(), "black", petStore3, "???");

        /*Ajouter un product au petStore et un petStore au product*/
        petStore1.ajouterProducts(product1);
        petStore2.ajouterProducts(product2);
        petStore3.ajouterProducts(product3);

        /*Paramétrage de création de la DB avec JPA*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp-petstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        /*Insertion des objets adresse en DB*/
        em.persist(adresse1);
        em.persist(adresse2);
        em.persist(adresse3);

        /*Insertion dans la DB en cascade*/
        em.persist(petStore1);
        em.persist(petStore2);
        em.persist(petStore3);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}