package com.apivoiture.test.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dimension_model")
public class DimensionModel implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dimensions;
    private double empattement;
    private double gardeAuSol;

    public DimensionModel() {
    }

    public DimensionModel(String dimensions, double empattement, double gardeAuSol) {
        this.dimensions = dimensions;
        this.empattement = empattement;
        this.gardeAuSol = gardeAuSol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public double getEmpattement() {
        return empattement;
    }

    public void setEmpattement(double empattement) {
        this.empattement = empattement;
    }

    public double getGardeAuSol() {
        return gardeAuSol;
    }

    public void setGardeAuSol(double gardeAuSol) {
        this.gardeAuSol = gardeAuSol;
    }
}
