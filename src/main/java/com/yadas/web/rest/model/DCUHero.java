package com.yadas.web.rest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="dcu_heroes")
public class DCUHero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "hero_name", nullable = false)
    private String heroName;

    public DCUHero() {
    }

    public DCUHero(long id, String heroName) {
        this.id = id;
        this.heroName = heroName;
    }

    public DCUHero(String heroName) {
        this.heroName = heroName;
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
        return "DCUHero { " +
                "id=" + id +
                ", heroName='" + heroName + '\'' +
                '}';
    }
}
