package fr.pantheonsorbonne.ufr27.miage.service.impl;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import service.InfoGareService;
import fr.pantheonsorbonne.ufr27.miage.dao.TrainDAO;
import fr.pantheonsorbonne.ufr27.miage.jpa.Arret;
import fr.pantheonsorbonne.ufr27.miage.jpa.Train;
import service.MailingService;

@Stateless
public class InfoGareServiceImpl implements InfoGareService {

	@Inject
	EntityManager em;
	
	@Inject
	MailingService ms;
	
	@Inject 
	TrainDAO TrainDAO;

	@Override
	public void afficherRetard(Train train, long retard) throws IOException {
		String cause="";
		if(retard==10) {
			cause="incident-tech";
		}
		else if(retard==25) {
			cause=	"incident-voyageur";
		}
		else if(retard==30) {
			cause="incident-colis";
		}
		else cause="error";
		System.out.println("Le retard est de :"+retard+ "est la cause est"+cause);
	}

	@Override
	public void afficherTrajet(Train train, Arret arret) throws IOException {
		int i=1;
		for(Arret a : TrainDAO.getArrets(train.getIdTrain())) {
			System.out.println("Arrêt numéro "+i+"est "+a);
			i++;
		}
		
	}

	@Override
	public void afficherHeureArr(Train train) throws IOException {
		System.out.println("Heure d'arrivée du train numéro "+train.getIdTrain()+" : " +TrainDAO.getHeureArr(train.getIdTrain()));
	}

	

	

}
