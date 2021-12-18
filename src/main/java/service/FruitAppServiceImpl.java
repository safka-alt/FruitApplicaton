package service;

import connector.FruitAPIConnector;
import entity.FamilyEntity;
import entity.FruitEntity;
import mapper.FruitMapper;
import model.Familly;
import model.Fruit;
import repository.FamillyRepository;
import repository.FruitRepository;

import java.util.HashMap;
import java.util.List;

public class FruitAppServiceImpl implements FruitAppService{
    private final FruitAPIConnector fruitAPIConnector;
    private final FruitRepository fruitRepository;

    public FruitAppServiceImpl(FruitAPIConnector fruitAPIConnector, FruitRepository fruitRepository) {
        this.fruitAPIConnector = fruitAPIConnector;
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> getAll() {
        //List<Fruit> fruitEntityList = fruitRepository.getAll();

        //if (!fruitEntityList.isEmpty()) {
          //return fruitEntityList;
        //}
        //else {
            System.out.println("Get ALL from API");
           List<Fruit> fruitEntityList = fruitAPIConnector.getAll();
           HashMap<String,Long> familyMap = new HashMap<>();
           long i=1;
            for (Fruit fruit :fruitEntityList) {
                FamilyEntity familyEntity = new FamilyEntity();
                if (familyMap.get(fruit.getFamily()) == null) {
                    familyMap.put(fruit.getFamily(), i);
                    i++;
                    familyEntity.setName(fruit.getFamily());
                    familyEntity.setId(familyMap.get(fruit.getFamily()));
                    System.out.println("Familly ENtity " +familyEntity.toString());
                    fruitRepository.save(familyEntity);

                }
                //FamilyEntity familyEntity = FruitMapper.mapFamilyToFamilyEntity(fruit);
                FruitEntity fruitEntity = FruitMapper.mapFruitToFruitEntity(fruit);
                familyEntity.setName(fruit.getFamily());
                familyEntity.setId(familyMap.get(fruit.getFamily()));
                fruitEntity.setFamilyEntity(familyEntity);


                fruitRepository.save(fruitEntity);
            }

           return fruitEntityList;

        //}
    }

    @Override
    public Fruit getFruitByName(String name) {
        FruitEntity fruitEntity = fruitRepository.getFruitByName(name);

        if (fruitEntity == null) {
            System.out.println("API");
            Fruit fruit = fruitAPIConnector.getFruitByName(name);
            fruitEntity = FruitMapper.mapFruitToFruitEntity(fruit);
            fruitRepository.save(fruitEntity);
            System.out.println("API - koniec");
            return fruit;
        }
        else
        {
            Fruit fruit = FruitMapper.mapFruitEntityToFruit(fruitEntity);
            System.out.println("Z bazy : "+fruit.toString());
            return fruit;
        }



    }

    @Override
    public List<Fruit> getFruitsByFamily(String famillyName) {
        List<FruitEntity> fruitListbyFamilly = fruitRepository.getFruitByFamilly(famillyName);

        //System.out.println(fruitListbyFamilly.toString());
        List<Fruit> fruitList = null;
        for (FruitEntity fruitEntity : fruitListbyFamilly)
        {
            System.out.println( fruitEntity.getFamilyEntity());
            System.out.println(fruitEntity.toString());
            fruitList.add( FruitMapper.mapFruitEntityToFruit(fruitEntity));
        }
        return fruitList;
    }

    @Override
    public List<Fruit> saveAll() {
        return null;
    }

    @Override
    public Fruit searchFruitByParameters(String columnName, String parameter) {
        FruitEntity fruitEntity = fruitRepository.searchFruitByParameters(columnName,parameter);
        Fruit fruit = FruitMapper.mapFruitEntityToFruit(fruitEntity);
        System.out.println("Z bazy : "+fruit.toString());
        return fruit;
    }
}
