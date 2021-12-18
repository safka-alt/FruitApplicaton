package application;
import model.Fruit;
import connector.FruitAPIConnectorImpl;

import java.util.List;
import java.util.Scanner;
import service.FruitAppService;

public class FruitApplication {

    private static FruitAppService fruitAppService;

    public FruitApplication(FruitAppService fruitAppService){
        this.fruitAppService = fruitAppService;
    }

    public static void start() {

        int choice = 1;
        try {
            Scanner scanner = new Scanner(System.in);
            printOptions();
            FruitAPIConnectorImpl fruitsAPIConnector = new FruitAPIConnectorImpl();
            while (choice !=0) {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        List<Fruit> fruitList = fruitAppService.getAll();
                        fruitList.stream().forEach(System.out::println);
                        printOptions();
                        break;
                    case 2:
                        System.out.println("Podaj nazwę owocu");
                        String name = scanner.nextLine();
                        Fruit fruit = fruitAppService.getFruitByName(name);
                        System.out.println(fruit.toString());
                        printOptions();
                        break;
                    case 3:
                        System.out.println("Podaj rodzinę owoców");
                        String famillyName = scanner.nextLine();
                        //List<Fruit> fruitListbyFamilly = fruitsAPIConnector.getFruitsByFamily(famillyName);
                        List<Fruit> fruitListbyFamilly = fruitAppService.getFruitsByFamily(famillyName);
                        System.out.println("GetbyFamilly: ");
                        fruitListbyFamilly.stream().forEach(System.out::println);
                        printOptions();
                        break;
                    case 4:
                        printOptionsFruitsOptions();
                        String columnName = scanner.nextLine();

                        //List<Fruit> fruitListbyFamilly = fruitsAPIConnector.getFruitsByFamily(famillyName);
                        printOptionsMinMax();
                        String parameter = scanner.nextLine();
                        System.out.println(columnName);

                        fruitAppService.searchFruitByParameters(columnName,parameter);

                        printOptions();
                        break;

                    case 0:
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
        System.out.println("4. Pokaż dane o owocach ");
        System.out.println("0. Zakończ działanie programu");
    }
    private static void printOptionsMinMax(){
        System.out.println("\nWypierz opcje: \n");
        System.out.println("1. MIN");
        System.out.println("2. MAX");
    }
    private static void printOptionsFruitsOptions(){
        System.out.println("\n Podaj nazwę kolumny: \n");
        System.out.println("fat");
        System.out.println("calories");
        System.out.println("protein");
        System.out.println("sugar");

    }


}
