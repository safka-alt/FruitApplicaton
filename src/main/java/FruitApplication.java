import connector.FruitsAPIConnector;
import dto.Fruit;

import java.util.List;

public class FruitApplication {
    public static void main(String[] args) {
        FruitsAPIConnector fruitsAPIConnector = new FruitsAPIConnector();
        List<Fruit> fruitList = fruitsAPIConnector.getAll();
        System.out.println("GetALL: ");
        fruitList.stream().forEach(System.out::println);
        Fruit fruit = new Fruit();
        System.out.println("getFruitByName");
         fruit = fruitsAPIConnector.getFruitByName("Apple");
        System.out.println(fruit.toString());


        /*
        FootballApiConnector footballApiConnector = new FootballApiConnector();

        List<League >leagueList = footballApiConnector.getAllLeagues();

//        leagueList.stream().forEach(System.out::println);

        footballApiConnector.leagueDetails("arg.1");*/

    }
}
