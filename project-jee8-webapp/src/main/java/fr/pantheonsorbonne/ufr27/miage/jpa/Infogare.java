package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="infogare")
public class Infogare {
	
	@Id
	int idInfogare;
	String typeInfogare;
	Train idTrain;
	Train chemin;
	TrainPhysique idTrainPhysique;
	Gare idGare;
	
	public int getIdInfogare() {
		return idInfogare;
	}
	public void setIdInfogare(int idInfogare) {
		this.idInfogare = idInfogare;
	}
	public String getTypeInfogare() {
		return typeInfogare;
	}
	public void setTypeInfogare(String typeInfogare) {
		this.typeInfogare = typeInfogare;
	}
	public Train getIdTrain() {
		return idTrain;
	}
	public void setIdTrain(Train idTrain) {
		this.idTrain = idTrain;
	}
	public Train getChemin() {
		return chemin;
	}
	public void setChemin(Train chemin) {
		this.chemin = chemin;
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
	

}
