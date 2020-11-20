package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Infogare {
	
	@Id
	int idInfogare;
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
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public Train getChemin() {
		return chemin;
	}
	public void setChemin(Train chemin) {
		this.chemin = chemin;
	}
	public TrainPhysique getTrainPhysique() {
		return trainPhysique;
	}
	public void setTrainPhysique(TrainPhysique trainPhysique) {
		this.trainPhysique = trainPhysique;
	}
	public Gare getGare() {
		return gare;
	}
	public void setGare(Gare gare) {
		this.gare = gare;
	}
	String typeInfogare;
	Train train;
	Train chemin;
	TrainPhysique trainPhysique;
	Gare gare;


}
