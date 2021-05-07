package com.yadas.web.rest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="dcu_heros")
public class DCUHeroes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String heroName;

    public DCUHeroes() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }


    @Override
    public String toString() {
        return "DCU_HEROS{" +
                "id=" + id +
                ", heroName='" + heroName + '\'' +
                '}';
    }
}
