package mapper;
import entity.*;
import model.*;

public class FruitMapper {

    public static Fruit mapFruitEntityToFruit(FruitEntity fruitEntity) {
        Fruit fruit = new Fruit();

        // use setters
        // book.setName(fruitEntity.getName());

        return fruit;
    }

    public static FruitEntity mapFruitToFruitEntity(Fruit fruit) {
        FruitEntity fruitEntity = new FruitEntity();

        // use setters
        // bookEntity.setName(book.getName());

        return fruitEntity;
    }
}
