package repository;
import entity.FamilyEntity;
import entity.FruitEntity;
import model.Fruit;

import java.util.List;

public interface FruitRepository {
    List<Fruit> getAll();
    abstract FruitEntity getFruitByName(String name);
    abstract List<FruitEntity> getFruitByFamilly(String name);
    abstract FruitEntity save(FruitEntity fruitEntity);
    abstract FruitEntity searchFruitByParameters(String columnName, String parameter);
    abstract FamilyEntity save(FamilyEntity familyEntity);



}
