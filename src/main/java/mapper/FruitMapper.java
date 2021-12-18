package mapper;
import entity.*;
import model.*;

public class FruitMapper {

    public static Fruit mapFruitEntityToFruit(FruitEntity fruitEntity) {
        Fruit fruit = new Fruit();

        // use setters
        fruit.setName(fruitEntity.getName());
        fruit.setCalories(fruitEntity.getCalories());
        fruit.setFat(fruitEntity.getFat());
        fruit.setProtein(fruitEntity.getProtein());
        fruit.setSugar(fruitEntity.getSugar());
        fruit.setCarbohydrates(fruitEntity.getCarbohydrates());

        return fruit;
    }

    public static FruitEntity mapFruitToFruitEntity(Fruit fruit) {
        FruitEntity fruitEntity = new FruitEntity();
        fruitEntity.setName(fruit.getName());
        fruitEntity.setCalories(fruit.getCalories());
        fruitEntity.setFat(fruit.getFat());
        fruitEntity.setCarbohydrates(fruit.getCarbohydrates());
        fruitEntity.setProtein(fruit.getProtein());
        fruitEntity.setSugar(fruit.getSugar());

        return fruitEntity;
    }

    public static FamilyEntity mapFamilyToFamilyEntity(Fruit fruit) {
        FamilyEntity familyEntity = new FamilyEntity();
        familyEntity.setName(fruit.getFamily());
        return familyEntity;
    }
}
