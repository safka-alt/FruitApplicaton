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


/*private static final String URL = "https://wolnelektury.pl";

    public List<Book> getAll() {

        List<Book> result = new ArrayList<>();

        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL + "/api/books/"))
                    .GET()
                    .build();


            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONArray jsonArray = new JSONArray(httpResponse.body());
            jsonArray.iterator().forEachRemaining(s -> {

                JSONObject jsonObject= (JSONObject) s;

                Book book = new Book();
                book.setAuthor(jsonObject.getString("author"));
                book.setTitle(jsonObject.getString("title"));
                book.setKind(jsonObject.getString("kind"));
                book.setEpoch(jsonObject.getString("epoch"));
                book.setGenre(jsonObject.getString("genre"));
                book.setUrl(jsonObject.getString("url"));

                result.add(book);
*/




    public List<Fruit> getAll() {

        List<Fruit> result = new ArrayList<>();

        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL + "/api/fruit/all"))
                    .GET()
                    .build();


            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse.body().toString());

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



                        /*System.out.println(nutritions.toString());
                        System.out.println("FAT: "+ nutritions.getFloat("fat"));
                        System.out.println("FAT: "+ nutritions.getFloat("calories"));
                        System.out.println("FAT: "+ nutritions.getFloat("protein"));
                        System.out.println("FAT: "+ nutritions.getFloat("carbohydrates"));
                        System.out.println("FAT: "+ nutritions.getFloat("sugar"));
*/
                        //fruit.setId();
                        System.out.println("S "+s);
                        result.add(fruit);
                    }

                    );
            System.out.println(jsonArray.toString());

           /* JSONArray jsonArray = jsonObject.getJSONArray("data");
            jsonArray.iterator().forEachRemaining(s -> {
                Fruit fruit = new Fruit();
                JSONObject object = (JSONObject) s;
                fruit.setId(object.getString("id"));
                fruit.setName(object.getString("name"));
                //fruitl.add(fruit);
            });*/

            System.out.println("Result: "+result);

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

                fruit.setName(object.getString("name").toLowerCase());
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
                    .uri(new URI(URL + "/api/fruit/" + name))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONArray jsonArrayq = new JSONArray(httpResponse.body());
            //JSONArray jsonArray = new JSONArray(httpResponse.body());
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
                fruit.setSugar(nutritions.getFloat("sugar"));
            });


        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
   /* public List<CurrencyValue> getAll(String currencyCode) {
        return getAll(currencyCode, new Date());
    }

    public List<CurrencyValue> getAll(String currencyCode, Date date) {
        List<CurrencyValue> result = new ArrayList<>();

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(date);
            String currDate = dateFormat.format(new Date());

            URI uri;
            if (strDate.equals(currDate)) {
                uri = new URI(URL + "latest/currencies/" + currencyCode + ".json");
            } else {
                uri = new URI(URL + strDate + "/currencies/" + currencyCode + ".json");
            }

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();


            HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonObject = new JSONObject(httpResponse.body());
            jsonObject = jsonObject.getJSONObject(currencyCode);
            JSONObject finalJsonObject = jsonObject;
            jsonObject.keys().forEachRemaining(s -> {
                CurrencyValue currency = new CurrencyValue();
                currency.setBaseCurrencyCode(currencyCode);
                currency.setCurrencyCode(s);
                try {
                    currency.setDate(dateFormat.parse(strDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                currency.setValue(finalJsonObject.getBigDecimal(s));

                result.add(currency);
            });

            System.out.println(result);

        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
*/



}
