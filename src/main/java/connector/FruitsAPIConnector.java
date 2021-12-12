package connector;

import dto.Fruit;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FruitsAPIConnector {

private static final String URL = "https://www.fruityvice.com";

    public List<Fruit> getAll() {

        List<Fruit> result = new ArrayList<>();

        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL + "/api/fruit/all"))
                    .GET()
                    .build();


            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONArray jsonArray = new JSONArray(httpResponse.body());
            jsonArray.iterator().forEachRemaining(s->
                    {
                        Fruit fruit = new Fruit();
                        JSONObject object =  (JSONObject)  s;
                        fruit.setId(object.getInt("id"));
                        fruit.setName(object.getString("name"));
                        fruit.setFamily(object.getString("family"));
                        fruit.setGenus(object.getString("genus"));
                        JSONObject nutritions = object.getJSONObject("nutritions");
                        fruit.setCalories( nutritions.getFloat("calories"));
                        fruit.setFat(nutritions.getFloat("calories"));
                        fruit.setProtein(nutritions.getFloat("protein"));
                        fruit.setSugar(nutritions.getFloat("sugar"));
                        fruit.setCarbohydrates(nutritions.getFloat("carbohydrates"));
                        result.add(fruit);
                    }

                    );

        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public Fruit getFruitByName(String name) {
        Fruit fruit = new Fruit();
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL + "/api/fruit/" + name))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONObject object = new JSONObject(httpResponse.body());
            fruit.setName(object.getString("name"));
            fruit.setId(object.getInt("id"));
            fruit.setFamily(object.getString("family"));
            fruit.setGenus(object.getString("genus"));
            JSONObject nutritions = object.getJSONObject("nutritions");
            fruit.setCalories( nutritions.getFloat("calories"));
            fruit.setFat(nutritions.getFloat("calories"));
            fruit.setProtein(nutritions.getFloat("protein"));
            fruit.setSugar(nutritions.getFloat("sugar"));
            fruit.setCarbohydrates(nutritions.getFloat("carbohydrates"));

        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return fruit;
    }



    public List<Fruit> getFruitsByFamily(String name) {
        List<Fruit> result = new ArrayList<>();
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL + "/api/fruit/family/" + name))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());


            JSONArray jsonArray = new JSONArray(httpResponse.body());
            jsonArray.iterator().forEachRemaining(s->
            {
                Fruit fruit = new Fruit();
                JSONObject object = (JSONObject) s;
                fruit.setName(object.getString("name").toLowerCase());
                fruit.setId(object.getInt("id"));
                fruit.setFamily(object.getString("family"));
                fruit.setGenus(object.getString("genus"));
                JSONObject nutritions = object.getJSONObject("nutritions");
                fruit.setCalories(nutritions.getFloat("calories"));
                fruit.setFat(nutritions.getFloat("calories"));
                fruit.setProtein(nutritions.getFloat("protein"));
                result.add(fruit);
            });

        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
