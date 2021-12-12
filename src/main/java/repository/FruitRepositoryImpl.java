package repository;

import entity.FruitEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FruitRepositoryImpl implements FruitRepository{

    @Override
    public List<FruitEntity> getAll() {
        return null;
    }

    @Override
    public FruitEntity getFruitByName(String name) {
        return null;
    }

    @Override
    public FruitEntity getFruitByFamilly(String name) {
        return null;
    }

    @Override
    public FruitEntity save(FruitEntity fruitEntity) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fruits");
       // System.out.println("111111");
        //fruitEntity.setName("Jabłko");
        System.out.println( fruitEntity.toString());
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(fruitEntity);
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("Done");
        return fruitEntity;
    }
}
