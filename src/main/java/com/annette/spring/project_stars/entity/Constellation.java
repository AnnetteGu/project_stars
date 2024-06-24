package com.annette.spring.project_stars.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "constellations")
public class Constellation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "star_amount")
    private int starAmount;

    @Column(name = "is_zodiac")
    private boolean isZodiac;

    @OneToMany(cascade = CascadeType.ALL, 
                mappedBy = "constellation")
    private List<ConstellationInf> constInf;

    public Constellation() {
    }

    public Constellation(String name, int starAmount, boolean isZodiac) {
        this.name = name;
        this.starAmount = starAmount;
        this.isZodiac = isZodiac;
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

    public int getStarAmount() {
        return starAmount;
    }

    public void setStarAmount(int starAmount) {
        this.starAmount = starAmount;
    } 

    public boolean getIsZodiac() {
        return isZodiac;
    }

    public void setIsZodiac(boolean isZodiac) {
        this.isZodiac = isZodiac;
    }

    public List<ConstellationInf> getConstInf() {
        return constInf;
    }

    public void setConstInf(List<ConstellationInf> constInf) {
        this.constInf = constInf;
    }

    @Override
    public String toString() {
        return "Constellation [id=" + id + ", name=" + name + ", starAmount=" + starAmount + ", isZodiac=" + isZodiac
                + ", constInf=" + constInf + "]";
    }

    

}