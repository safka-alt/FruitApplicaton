package repository;
import entity.FruitEntity;
import java.util.List;

public interface FruitRepository {
    List<FruitEntity> getAll();
    abstract FruitEntity getFruitByName(String name);
    abstract FruitEntity getFruitByFamilly(String name);
    abstract FruitEntity save(FruitEntity fruitEntity);

}
