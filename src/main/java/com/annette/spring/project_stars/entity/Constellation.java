package com.annette.spring.project_stars.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "const_id")
    private List<ConstellationInf> constInfs;

    public Constellation() {
    }

    public Constellation(String name, int starAmount, boolean isZodiac) {
        this.name = name;
        this.starAmount = starAmount;
        this.isZodiac = isZodiac;
    }

    public void addConstInfToConstellation(ConstellationInf constInfs) {

        if (this.constInfs == null) this.constInfs = new ArrayList<>();

        else this.constInfs.add(constInfs);

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

    public List<ConstellationInf> getConstInfs() {
        return constInfs;
    }

    public void setConstInfs(List<ConstellationInf> constInfs) {
        this.constInfs = constInfs;
    }

    @Override
    public String toString() {
        return "Constellation [id=" + id + ", name=" + name + ", starAmount=" + starAmount + ", isZodiac=" + isZodiac
                + ", constInfs=" + constInfs + "]";
    }

    

}