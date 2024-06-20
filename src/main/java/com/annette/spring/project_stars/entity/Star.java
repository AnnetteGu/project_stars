package com.annette.spring.project_stars.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stars")
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "code_number")
    private String codeNumber;

    @Column(name = "type")
    private String type;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "luminosity")
    private double luminosity;

    @Column(name = "weight")
    private double weight;

    @Column(name = "price")
    private int price;

    @ManyToOne(cascade = {
        CascadeType.DETACH,
        CascadeType.MERGE,
        CascadeType.PERSIST,
        CascadeType.REFRESH
    })
    @JoinColumn(name = "keeper_id")
    private User starKeeper;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "const_inf_id")
    private ConstellationInf starConstInf;

    @OneToMany(cascade = CascadeType.ALL,
                mappedBy = "star")
    private List<Comment> starComments;

    public Star() {
    }

    public Star(String name, String codeNumber, String type, double temperature, double luminosity, double weight,
            int price) {
        this.name = name;
        this.codeNumber = codeNumber;
        this.type = type;
        this.temperature = temperature;
        this.luminosity = luminosity;
        this.weight = weight;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(double luminosity) {
        this.luminosity = luminosity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getStarKeeper() {
        return starKeeper;
    }

    public void setStarKeeper(User starKeeper) {
        this.starKeeper = starKeeper;
    }

    public ConstellationInf getStarConstInf() {
        return starConstInf;
    }

    public void setStarConstInf(ConstellationInf starConstInf) {
        this.starConstInf = starConstInf;
    }

    public List<Comment> getStarComments() {
        return starComments;
    }

    public void setStarComments(List<Comment> starComments) {
        this.starComments = starComments;
    }

    @Override
    public String toString() {
        return "Star [id=" + id + ", name=" + name + ", codeNumber=" + codeNumber + ", type=" + type + ", temperature="
                + temperature + ", luminosity=" + luminosity + ", weight=" + weight + ", price=" + price
                + ", starKeeper=" + starKeeper + ", starConstInf=" + starConstInf + ", starComment=" + starComments
                + "]";
    }

}