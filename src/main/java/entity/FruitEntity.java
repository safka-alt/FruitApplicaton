package entity;

import javax.persistence.*;

@Entity
public class FruitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    @Column(nullable = false,length = 25)
    private String name;
    private float fat;
    private float sugar;
    private float calories;
    private float protein;
    private float carbohydrates;
    @OneToOne
    @JoinColumn(name = "family_id")
    private FamilyEntity familyEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public FamilyEntity getFamilyEntity() {
        return familyEntity;
    }

    public void setFamilyEntity(FamilyEntity familyEntity) {
        this.familyEntity = familyEntity;
    }

    @Override
    public String toString() {
        return "FruitEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fat=" + fat +
                ", sugar=" + sugar +
                ", calories=" + calories +
                ", protein=" + protein +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}
