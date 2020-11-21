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
public interface InfoGareService {

	
}