package com.annette.spring.project_stars.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "const_infs")
public class ConstellationInf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "const_id")
    private int constId;

    @Column(name = "const_role")
    private String constRole;

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

    public int getConstId() {
        return constId;
    }

    public void setConstId(int constId) {
        this.constId = constId;
    }

    @Override
    public String toString() {
        return "ConstellationInf [id=" + id + ", constId=" + constId + ", constRole=" + constRole + "]";
    }

}