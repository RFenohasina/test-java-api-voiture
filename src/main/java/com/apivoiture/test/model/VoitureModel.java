package com.apivoiture.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="voitures")
public class VoitureModel implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String couleur;
    private String marque;
    private String type;
    private double capaciteReservoir;
    private double poids;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "moteur")
    private MoteurModel moteur;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dimension")
    private DimensionModel dimension;

    @OneToMany(mappedBy = "voiture")
    @JsonIgnore
    private Collection<CommentairesModel> listCommentaire;

    public VoitureModel() {

    }

    public VoitureModel(String couleur, String marque, String type, double capaciteReservoir, double poids, MoteurModel moteur, DimensionModel dimension) {
        this.couleur = couleur;
        this.marque = marque;
        this.type = type;
        this.capaciteReservoir = capaciteReservoir;
        this.poids = poids;
        this.moteur = moteur;
        this.dimension = dimension;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCouleur() { return couleur; }
    public void setCouleur(String couleur) { this.couleur = couleur; }

    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public MoteurModel getMoteur() { return moteur; }
    public void setMoteur(MoteurModel moteur) { this.moteur = moteur; }

    public DimensionModel getDimension() { return dimension; }
    public void setDimension(DimensionModel dimension) { this.dimension = dimension; }

    public Collection<CommentairesModel> getListCommentaire() { return listCommentaire; }
    public void setListCommentaire(Collection<CommentairesModel> listCommentaire) { this.listCommentaire = listCommentaire; }

    public double getCapaciteReservoir() { return capaciteReservoir; }
    public void setCapaciteReservoir(double capaciteReservoir) { this.capaciteReservoir = capaciteReservoir; }

    public double getPoids() { return poids; }
    public void setPoids(double poids) { this.poids = poids; }
}
