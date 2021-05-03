package com.apivoiture.test;

import com.apivoiture.test.model.*;
import com.apivoiture.test.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@SpringBootApplication
public class ApiListeVoitureApplication implements CommandLineRunner {

	@Autowired
	private MoteurRepository moteurRepository;

	@Autowired
	private DimensionRepository dimensionRepository;

	@Autowired
	private VoitureRepository voitureRepository;

	@Autowired
	private CommentaireRepository commentaireRepository;

	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(ApiListeVoitureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//New Line
		moteurRepository.save(new MoteurModel("Injection MultiPoint", "Essence, Diesel", 1589));
		dimensionRepository.save(new DimensionModel("3645*1645*1725", 2250,210));
		voitureRepository.save(new VoitureModel("Jaune", "PEUGEOT ", "Plaisir",47,1075, moteurRepository.findMoteurById(1), dimensionRepository.findDimensionById(1)));
		userRepository.save(new UserModel("cp1Azur", "1234"));
		commentaireRepository.save(new CommentairesModel("Commentaires", new Date(), voitureRepository.findVoitureById(1), userRepository.findUserById(1)));

		//New Line
		moteurRepository.save(new MoteurModel("Injection MultiPoint", "Essence, Diesel", 1589));
		dimensionRepository.save(new DimensionModel("3645*1645*1725", 2250,210));
		voitureRepository.save(new VoitureModel("Rouge", "Suzuki ", "Plaisir",47,1075, moteurRepository.findMoteurById(2), dimensionRepository.findDimensionById(2)));
		userRepository.save(new UserModel("cp1Azur", "1234"));
		commentaireRepository.save(new CommentairesModel("Commentaires numéro 2 sur le SUZUKI :-) ", new Date(), voitureRepository.findVoitureById(2), userRepository.findUserById(2)));
	}
}
