package com.example.OlympicsDemo.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="country")
public class Country
{
// define fields

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="country_id")
    private int countryId;
    @Column(name="country_name")
    private String countryName;

    @OneToMany(mappedBy="country",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Player> players;

    // define constructors
    public Country(){

    }
    public Country(int id, String name)
    {
        id=countryId;
        name=countryName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                '}';
    }
    public void add(Player tempCourse) {

        if (players == null) {
            players = new ArrayList<>();
        }

        players.add(tempCourse);

        tempCourse.setCountry(this);
    }
}
