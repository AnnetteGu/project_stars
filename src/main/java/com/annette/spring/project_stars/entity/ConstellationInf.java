package com.annette.spring.project_stars.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "const_infs")
public class ConstellationInf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "constRole")
    private String constRole;

    @OneToOne(cascade = {
        CascadeType.DETACH,
        CascadeType.MERGE,
        CascadeType.PERSIST,
        CascadeType.REFRESH
    }, mappedBy = "starConstInf")
    private Star star;

    @ManyToOne(cascade = {
        CascadeType.DETACH,
        CascadeType.MERGE,
        CascadeType.PERSIST,
        CascadeType.REFRESH
    })
    @JoinColumn(name = "const_id")
    private Constellation constellation;

    public ConstellationInf() {
    }

    public ConstellationInf(String constRole) {
        this.constRole = constRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConstRole() {
        return constRole;
    }

    public void setConstRole(String constRole) {
        this.constRole = constRole;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }

    @Override
    public String toString() {
        return "ConstellationInf [id=" + id + ", constRole=" + constRole + ", star=" + star + ", constellation="
                + constellation + "]";
    }

}