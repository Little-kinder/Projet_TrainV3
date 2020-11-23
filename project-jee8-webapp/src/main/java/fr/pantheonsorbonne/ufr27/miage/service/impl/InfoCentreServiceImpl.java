package fr.pantheonsorbonne.ufr27.miage.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import fr.pantheonsorbonne.ufr27.miage.jpa.Arret;
import fr.pantheonsorbonne.ufr27.miage.jpa.Contract;
import fr.pantheonsorbonne.ufr27.miage.jpa.Customer;
import fr.pantheonsorbonne.ufr27.miage.jpa.Invoice;
import fr.pantheonsorbonne.ufr27.miage.jpa.Train;
import fr.pantheonsorbonne.ufr27.miage.jpa.TrainPhysique;
import service.InfoCentreService;
import fr.pantheonsorbonne.ufr27.miage.dao.TrainDAO;
import service.InvoicingService;
import fr.pantheonsorbonne.ufr27.miage.jpa.Train;
import service.InfoCentreService;

import fr.pantheonsorbonne.ufr27.miage.dao.TrainDAO;
import fr.pantheonsorbonne.ufr27.miage.service.impl.InfoGareServiceImpl;
import service.MailingService;

@Stateless
public class InfoCentreServiceImpl implements InfoCentreService {

	@Inject
	EntityManager em;
	
	@Inject
	MailingService ms;
	
	@Inject 
	TrainDAO TrainDAO;

	
	String perturbation = "none";
	

	@Override 
	public void affichageInfoGare(Train train) throws IOException {
		int idTrain = train.getIdTrain();
		InfoGareServiceImpl info = new InfoGareServiceImpl();
		long retard = gestionRetard(idTrain);
		
		if(retard>0){
			info.afficherRetard(train,retard);
		}
		info.afficherTrajet(train);
		info.afficherHeureArr(train);
		
	}
	
	@Override
	public void ajoutRetard(Train train, long retard) throws IOException {
		TrainDAO.getHeureArr(train.getIdTrain()).plusMinutes(retard);

		
	}
	
	@Override
	public void suppArret_Trajet(Train train, Arret arret) throws IOException {
		 TrainDAO.getArrets(train.getIdTrain()).remove(arret); 
		 int idArret = arret.getIdArret();
		 em.createNativeQuery("delete arrivee from Train where arrivee = :idArret and idTrain = :idTrain")
		 	.setParameter("arrivee", idArret).setParameter("idTrain", train.getIdTrain());
	}
	
	
	@Override
	public void addArret_Trajet(Train train, Arret arret) throws IOException {
		 TrainDAO.getArrets(train.getIdTrain()).add(arret);
		 int idArret = arret.getIdArret();
		 em.createNativeQuery("insert into Train values ('idTrain', 'arrivee' )")
		 	.setParameter("arrivee", idArret).setParameter("idTrain", train.getIdTrain());
		 
	}

	@Override
	public void suppTrainPhysique_Trajet(int idTrain, int idTrainPhysique) throws IOException {
		
			Train currtrain = em.find(Train.class, idTrain);
			
			em.createNativeQuery("delete TrainPhysique from Train where idTrain = :idTrain ")
					.setParameter("idTrain", idTrain);
	
		
	}
	
	@Override
	public long gestionRetard(int idTrain) throws IOException {
		long retard = 0;
		Train train = em.find(Train.class, idTrain);
		
		if(!(perturbation == "none" ) && !(TrainDAO.getEtat(idTrain))) {
			if(perturbation == "incident-tech") {
				retard = 10;
				
			}
			else if(perturbation == "incident-voyageur") {
				retard = 25;
			}
			else if(perturbation == "incident-colis") {
				retard = 30;
			}
			
			ajoutRetard(train,retard);
			
			if(!(TrainDAO.getArrets(idTrain).isEmpty())) {
				List<Arret> liste_arret = TrainDAO.getArrets(idTrain);
				/*
				for(Arret i : liste_arret) {
					i.getHeureDepart().plusMinutes(retard);

			
				 * for(Arret i : liste_arret) { i.getHeureDepart().plusMinutes(retard); }
				 */

			}
			
		}
		return retard;
		
	}

	

}
