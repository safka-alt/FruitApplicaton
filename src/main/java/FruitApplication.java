import connector.FruitsAPIConnector;
import dto.Fruit;
import java.util.List;
import java.util.Scanner;


public class FruitApplication {
    public static void main(String[] args) {
        int choice = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            printOptions();
            FruitsAPIConnector fruitsAPIConnector = new FruitsAPIConnector();


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
                    default:
                        System.out.println("Wybrano niepoprawą opcję");
                }
            }

        } catch (NumberFormatException e) {
            System.err.println("Wrong number");
        }



    }
    public static void printOptions(){
        System.out.println("\n\nPodaj numer akcji, którą chciałbyś wykonać:\n");
        System.out.println("1. Pobierz dane o wszystkich owocach");
        System.out.println("2. Pobierz dane o danym owocu podając nazwę ");
        System.out.println("3. Pokaż owoce należące do danej rodziny ");
        System.out.println("4. Zakończ działanie programu");

    }
}
