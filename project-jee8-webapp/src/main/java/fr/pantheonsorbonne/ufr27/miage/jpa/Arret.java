package fr.pantheonsorbonne.ufr27.miage.jpa;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.pantheonsorbonne.ufr27.miage.model.jaxb.Train;
import fr.pantheonsorbonne.ufr27.miage.model.jaxb.TrainPhysique;

@Entity
@Table(name="arret")
public class Arret {

	@Id
	int idArret;
	
	Train idTrain;
	TrainPhysique idTrainPhysique;
	Gare idGare;
	
	public int getIdArret() {
		return idArret;
	}
	public void setIdArret(int idArret) {
		this.idArret = idArret;
	}
	public Train getIdTrain() {
		return idTrain;
	}
	public void setIdTrain(Train idTrain) {
		this.idTrain = idTrain;
	}
	public TrainPhysique getIdTrainPhysique() {
		return idTrainPhysique;
	}
	public void setIdTrainPhysique(TrainPhysique idTrainPhysique) {
		this.idTrainPhysique = idTrainPhysique;
	}
	public Gare getIdGare() {
		return idGare;
	}
	public void setIdGare(Gare idGare) {
		this.idGare = idGare;
	}
	public int getNumeroVoix() {
		return numeroVoix;
	}
	public void setNumeroVoix(int numeroVoix) {
		this.numeroVoix = numeroVoix;
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
	
	int numeroVoix;
	LocalDateTime heureDepart;
	LocalDateTime heureArrivee;
	
}
