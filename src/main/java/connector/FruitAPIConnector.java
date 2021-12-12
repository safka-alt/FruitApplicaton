package connector;

import model.Fruit;

import java.util.List;

public interface FruitAPIConnector {

    abstract List<Fruit> getAll();
    abstract Fruit getFruitByName(String name);
    abstract List<Fruit> getFruitsByFamily(String name);


}
