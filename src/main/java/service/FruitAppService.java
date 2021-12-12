package service;
import model.Fruit;
import java.util.List;

public interface FruitAppService {
    List<Fruit> getAll();
    Fruit  getFruitByName(String name);
    List<Fruit> getFruitsByFamily();
}
