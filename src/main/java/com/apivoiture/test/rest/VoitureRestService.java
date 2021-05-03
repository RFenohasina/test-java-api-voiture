package com.apivoiture.test.rest;

import com.apivoiture.test.model.VoitureModel;
import com.apivoiture.test.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoitureRestService {
    @Autowired
    private VoitureRepository voitureRepository;

    public VoitureRestService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    @RequestMapping(value = "/voitures", method = RequestMethod.GET)
    public List<VoitureModel> listeVoiture() {
        return voitureRepository.findAll();
    }

    @RequestMapping(value = "/voitures/findById/{idVoiture}", method = RequestMethod.GET)
    public VoitureModel findVoitureById(@PathVariable("idVoiture") Integer idVoiture) {
        return this.voitureRepository.findVoitureById(idVoiture);
    }
}
