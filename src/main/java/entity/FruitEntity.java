package entity;

import javax.persistence.*;

@Entity
public class FruitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    @Column(nullable = false,length = 25)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FruitEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
