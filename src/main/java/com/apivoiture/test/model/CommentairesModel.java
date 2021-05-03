package com.apivoiture.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "commentaire")
public class CommentairesModel implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String commentaires;
    private Date dateCreation;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "voiture")
    private VoitureModel voiture;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user")
    private UserModel user;

    public CommentairesModel() {
    }

    public CommentairesModel(String commentaires, Date dateCreation, VoitureModel voiture, UserModel user) {
        this.commentaires = commentaires;
        this.dateCreation = dateCreation;
        this.voiture = voiture;
        this.user = user;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCommentaires() { return commentaires; }
    public void setCommentaires(String commentaires) { this.commentaires = commentaires; }

    public Date getDateCreation() { return dateCreation; }
    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }

    @JsonIgnore
    public VoitureModel getVoiture() { return voiture; }
    @JsonSetter
    public void setVoiture(VoitureModel voiture) { this.voiture = voiture; }

    public UserModel getUser() { return user; }
    @JsonSetter
    public void setUser(UserModel user) { this.user = user; }
}
