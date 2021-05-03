package com.apivoiture.test.rest;

import com.apivoiture.test.model.CommentairesModel;
import com.apivoiture.test.model.VoitureModel;
import com.apivoiture.test.repository.CommentaireRepository;
import com.apivoiture.test.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CommentaireRestService {
    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private VoitureRepository voitureRepository;

    public CommentaireRestService(CommentaireRepository commentaireRepository,
                                  VoitureRepository voitureRepository) {
        this.commentaireRepository = commentaireRepository;
        this.voitureRepository     = voitureRepository;
    }

    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public void ajouteCommentaire(@RequestBody CommentairesModel commentairesModel) {
        commentairesModel.setDateCreation(new Date());
        this.commentaireRepository.save(commentairesModel);
    }

    @RequestMapping(value = "/comment/findByCar/{idVoiture}", method = RequestMethod.GET)
    public List<CommentairesModel> listCommentaire(@PathVariable("idVoiture") Integer id) {
        return this.commentaireRepository.listCom(id);
    }
}
