package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Train {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idTrain;
	public int getIdTrain() {
		return idTrain;
	}
	public void setIdTrain(int idTrain) {
		this.idTrain = idTrain;
	}
	public String getTypeTrain() {
		return typeTrain;
	}
	public void setTypeTrain(String typeTrain) {
		this.typeTrain = typeTrain;
	}
	public LocalDateTime getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(LocalDateTime heureDepart) {
		this.heureDepart = heureDepart;
	}
	public LocalDateTime getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(LocalDateTime heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public int getNbPassager() {
		return nbPassager;
	}
	public void setNbPassager(int nbPassager) {
		this.nbPassager = nbPassager;
	}
	String typeTrain;
	LocalDateTime heureDepart;
	LocalDateTime heureArrivee;
	boolean etat;
	int nbPassager;
	
}
