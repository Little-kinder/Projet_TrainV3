package fr.pantheonsorbonne.ufr27.miage.dao;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import fr.pantheonsorbonne.ufr27.miage.exception.NoSuchUserException;
import fr.pantheonsorbonne.ufr27.miage.jpa.Arret;
import fr.pantheonsorbonne.ufr27.miage.jpa.Contract;
import fr.pantheonsorbonne.ufr27.miage.jpa.Customer;
import fr.pantheonsorbonne.ufr27.miage.jpa.Invoice;
import fr.pantheonsorbonne.ufr27.miage.jpa.Passager;
import fr.pantheonsorbonne.ufr27.miage.jpa.Train;

@ManagedBean
public class TrainDAO {

	@Inject
	EntityManager em;

	public LocalDateTime getHeureDepart(int idTrain) throws IOException{

		Train currtrain = em.find(Train.class, idTrain);
		if (currtrain == null) {
			throw new IOException();
		}
		return currtrain.getHeureDepart();
	}

	public LocalDateTime getHeureArr(int idTrain) throws IOException{

		Train currtrain = em.find(Train.class, idTrain);
		if (currtrain == null) {
			throw new IOException();
		}
		return currtrain.getHeureArrivee();
	}
	
	public boolean etat(int idTrain) throws IOException{

		Train currtrain = em.find(Train.class, idTrain);
		if (currtrain == null) {
			throw new IOException();
		}
		return currtrain.isEtat();
	}
	
	public String typeTrain(int idTrain) throws IOException{

		Train currtrain = em.find(Train.class, idTrain);
		if (currtrain == null) {
			throw new IOException();
		}
		return currtrain.getTypeTrain();
	}
	public List<Passager> getPassager(int idTrain) throws IOException {

		Train currtrain = em.find(Train.class, idTrain);
		if (currtrain == null) {
			throw new IOException();
		}
		List<Passager> passagers = (List<Passager>) currtrain.getPassagers();
		return passagers;
	}
	public List<Arret> getArrets(int idTrain) throws IOException {

		Train currtrain = em.find(Train.class, idTrain);
		if (currtrain == null) {
			throw new IOException();
		}
		List<Arret> chemin = (List<Arret>) currtrain.getChemin();
		return chemin;
	}
}
