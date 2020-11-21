package fr.pantheonsorbonne.ufr27.miage.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Billet {
	@Id
	int idBillet;
	
	public int getIdBillet() {
		return idBillet;
	}
	public void setIdBillet(int idBillet) {
		this.idBillet = idBillet;
	}
	public TrainPhysique getTrainPhysique() {
		return trainPhysique;
	}
	public void setTrainPhysique(TrainPhysique trainPhysique) {
		this.trainPhysique = trainPhysique;
	}
	public Passager getPassager() {
		return passager;
	}
	public void setPassager(Passager passager) {
		this.passager = passager;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	TrainPhysique trainPhysique;
	
	@OneToOne(cascade = CascadeType.ALL)
	Passager passager;
	
	public Billet() {
		super();
	}
	
	public Billet(int idBillet) {
		this.idBillet = idBillet;
	}

	@Override
	public String toString() {
		return "Billet [id=" + idBillet + "]";
	}
}
