import application.*;
import connector.*;
import repository.*;
//import repository.*;
import repository.FruitRepository;
import service.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Startup {

    private static EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory(
            "fruits");

    private static EntityManager entityManager
            = entityManagerFactory.createEntityManager();
    public static void main(String[] args) {

        FruitAPIConnector apiConnector = new FruitAPIConnectorImpl();
        FruitRepository fruitRepository = new FruitRepositoryImpl(entityManager);
        FruitAppService fruitAppService = new FruitAppServiceImpl(apiConnector,fruitRepository);


        new FruitApplication(fruitAppService).start();




    }
}
