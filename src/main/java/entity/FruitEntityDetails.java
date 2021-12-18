package entity;

import javax.persistence.*;

@Entity
public class FruitEntityDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private long fruitID;

    private float fat;
    private float sugar;
    private float calories;
    private float protein;
    private float carbohydrates;

    public FruitEntityDetails() {
    }
}
