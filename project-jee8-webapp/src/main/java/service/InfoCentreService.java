package service;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.ejb.Remote;

import fr.pantheonsorbonne.ufr27.miage.exception.NoSuchUserException;
import fr.pantheonsorbonne.ufr27.miage.exception.UserHasDebtException;
import fr.pantheonsorbonne.ufr27.miage.jpa.Arret;
import fr.pantheonsorbonne.ufr27.miage.jpa.Train;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.FreeTrialPlan;

@Remote
public interface InfoCentreService {

	//public void gestionRetard(Train train);

	void ajoutRetard(Train train, long retard) throws IOException;
	

	void suppArret_Trajet(Train train, Arret arret) throws IOException;

	void addArret_Trajet(Train train, Arret arret) throws IOException;

	long gestionRetard(int idTrain) throws IOException;
	
	public void suppTrainPhysique_Trajet(int idTrain, int idTrainPhysiques) throws IOException ;
	



	void affichageInfoGare(Train train) throws IOException;
	
}