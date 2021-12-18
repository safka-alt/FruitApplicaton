package entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class FamilyEntity {
    @Id
    private long id;
    @Column(nullable = false, length = 25, unique = true)
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
}
