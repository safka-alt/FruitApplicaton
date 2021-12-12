import application.*;
import connector.*;
import entity.FruitEntity;
import model.Fruit;
import repository.*;
//import repository.*;
import repository.FruitRepository;
import service.*;


public class Startup {
    public static void main(String[] args) {

        FruitAPIConnector apiConnector = new FruitAPIConnectorImpl();
        //Repository repository = new RepositoryImpl();
        //AppService appService = new AppServiceImpl(apiConnector, repository);

        //new FruitApplication(appService).start();
        FruitEntity fruitEntity = new FruitEntity();
        fruitEntity.setName("Jabłko");
        new FruitRepositoryImpl().save(fruitEntity);
        FruitApplication.start();




    }
}
