package service;
import entity.FruitEntity;
import model.Fruit;

import java.security.SecureRandom;
import java.util.List;

public interface FruitAppService {
    List<Fruit> getAll();
    Fruit  getFruitByName(String name);
    List<Fruit> getFruitsByFamily(String familyName);
    List<Fruit> saveAll();
    Fruit searchFruitByParameters(String columnName, String parameter);
}
