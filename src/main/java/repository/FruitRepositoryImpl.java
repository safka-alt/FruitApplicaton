package repository;

import entity.FamilyEntity;
import entity.FruitEntity;
import model.Fruit;

import javax.persistence.*;
import java.util.List;

public class FruitRepositoryImpl implements FruitRepository {
    private EntityManager entityManager;

    public FruitRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Fruit> getAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fruits");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

        return null;
    }

    @Override
    public FruitEntity getFruitByName(String name) {
        FruitEntity fruit = null;

        try {
            Query query = entityManager.createQuery("FROM FruitEntity where name = " + "'" + name + "'");
            fruit = (FruitEntity) query.getSingleResult();


        } catch (NoResultException ignored) {

        }
        return fruit;

    }

    @Override
    public List<FruitEntity> getFruitByFamilly(String name) {
        /*select * from fruitentity f  "Rosaceae" ;*/
        /*select p.id as p_id,
           p.title as p_title,
           pc.id as pc_id,
           pc.review as pc_review from PostComment pc join pc.post p order by pc.id*/
        try {
            Query query = entityManager.createQuery("FROM FruitEntity f INNER JOIN  f.familyEntity fa where fa.name = " + "'" + name + "'");
            return query.getResultList();


        } catch (NoResultException ignored) {
        }
        return null;
    }


    @Override
    public FruitEntity save(FruitEntity fruitEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(fruitEntity);
        entityManager.getTransaction().commit();
        return fruitEntity;
    }

    @Override
    public FruitEntity searchFruitByParameters(String columnName, String parameter) {

        FruitEntity fruit = null;
        try {
            Query query = entityManager.createQuery("from FruitEntity where "+columnName+" in (select " + parameter + "(" + columnName + ") from FruitEntity )");

            System.out.println(query.getSingleResult());

             fruit =(FruitEntity) query.getSingleResult();
            System.out.println(fruit.toString());
            return fruit;

        } catch (NoResultException ignored) {
        }
            return null;

    }

    @Override
    public FamilyEntity save(FamilyEntity familyEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(familyEntity);
        entityManager.getTransaction().commit();
        return familyEntity;
    }
}