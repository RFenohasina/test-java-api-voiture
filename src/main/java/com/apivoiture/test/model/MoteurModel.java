package com.apivoiture.test.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="moteur")
public class MoteurModel implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String alimentation;
    private String carburant;
    private double cylindree;

    public MoteurModel() {
    }

    public MoteurModel(String alimentation, String carburant, double cylindree) {
        this.alimentation = alimentation;
        this.carburant = carburant;
        this.cylindree = cylindree;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlimentation() {
        return alimentation;
    }

    public void setAlimentation(String alimentation) {
        this.alimentation = alimentation;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public double getCylindree() {
        return cylindree;
    }

    public void setCylindree(double cylindree) {
        this.cylindree = cylindree;
    }
}
