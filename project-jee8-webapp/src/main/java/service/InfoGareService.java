package service;

import java.io.IOException;

import javax.ejb.Remote;

import fr.pantheonsorbonne.ufr27.miage.jpa.Arret;
import fr.pantheonsorbonne.ufr27.miage.jpa.Train;



@Remote
public interface InfoGareService {
	void afficherRetard(Train train, long retard) throws IOException;
	void afficherTrajet(Train train, Arret arret) throws IOException;
	void afficherHeureArr(Train train) throws IOException;
}