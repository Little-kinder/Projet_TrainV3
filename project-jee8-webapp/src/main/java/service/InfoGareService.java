package service;

import java.io.IOException;
import java.time.LocalDateTime;

import fr.pantheonsorbonne.ufr27.miage.exception.NoSuchUserException;
import fr.pantheonsorbonne.ufr27.miage.exception.UserHasDebtException;
import fr.pantheonsorbonne.ufr27.miage.jpa.Arret;
import fr.pantheonsorbonne.ufr27.miage.jpa.Train;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.FreeTrialPlan;


import javax.ejb.Remote;

import fr.pantheonsorbonne.ufr27.miage.jpa.Arret;
import fr.pantheonsorbonne.ufr27.miage.jpa.Train;



@Remote
public interface InfoGareService {
	void afficherRetard(Train train, long retard) throws IOException;
	void afficherTrajet(Train train) throws IOException;
	void afficherHeureArr(Train train) throws IOException;
}