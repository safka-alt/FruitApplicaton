package application;
import entity.FruitEntity;
import model.Fruit;
import connector.FruitAPIConnectorImpl;
import org.hibernate.type.EntityType;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class FruitApplication {
    //toDO
    //private final FruitAppService appService;

   // public FruitApplication(FruitAppService appService) {
     //   this.appService = appService;
    //}

    /*
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fruits");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    FruitEntity fruitEntity = new FruitEntity();
*/

    public FruitApplication(){
    }

    public static void start() {

        int choice = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            printOptions();
            FruitAPIConnectorImpl fruitsAPIConnector = new FruitAPIConnectorImpl();
            while (choice !=4) {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        List<Fruit> fruitList = fruitsAPIConnector.getAll();
                        System.out.println("GetALL: ");
                        fruitList.stream().forEach(System.out::println);
                        printOptions();
                        break;
                    case 2:
                        System.out.println("Podaj nazwę owocu");
                        String name = scanner.nextLine();
                        Fruit fruit = new Fruit();
                        System.out.println("getFruitByName");
                        fruit = fruitsAPIConnector.getFruitByName(name);
                        System.out.println(fruit.toString());
                        printOptions();
                        break;
                    case 3:
                        System.out.println("Podaj rodzinę owoców");
                        String famillyName = scanner.nextLine();
                        List<Fruit> fruitListbyFamilly = fruitsAPIConnector.getFruitsByFamily(famillyName);
                        System.out.println("GetbyFamilly: ");
                        fruitListbyFamilly.stream().forEach(System.out::println);
                        printOptions();
                        break;
                    case 4:
                        System.out.println("Zapraszamy ponownie");
                        break;
                    default:
                        System.out.println("Wybrano niepoprawą opcję");
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Wrong number");
        }
    }
    private static void printOptions(){
        System.out.println("\n\nPodaj numer akcji, którą chciałbyś wykonać:\n");
        System.out.println("1. Pobierz dane o wszystkich owocach");
        System.out.println("2. Pobierz dane o danym owocu podając nazwę ");
        System.out.println("3. Pokaż owoce należące do danej rodziny ");
        System.out.println("4. Zakończ działanie programu");
    }
}
