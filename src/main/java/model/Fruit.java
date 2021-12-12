package model;

public class Fruit {
    private String name;
    private int id;
    private String family;
    private String genus;
    private float fat;
    private float sugar;
    private float calories;
    private float protein;
    private float carbohydrates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getSugar() {
        return sugar;
    }

    public void setSugar(float sugar) {
        this.sugar = sugar;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }


    public void setGenus(String genus) {
        this.genus = genus;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", family='" + family + '\'' +
                ", genus='" + genus + '\'' +
                ", fat=" + fat +
                ", sugar=" + sugar +
                ", calories=" + calories +
                ", protein=" + protein +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}

